package com.cmfchina.dataportal.service.impl;

import com.cmfchina.dataportal.service.FileStorageService;
import com.cmfchina.dataportal.utils.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private static final Logger log = LoggerFactory.getLogger(FileStorageServiceImpl.class);


    @Value("${file.upload-dir}")
    private String uploadDir;


    /**
     * 存储上传的文件
     *
     * @param file   上传的文件
     * @param prefix 可选的URL前缀
     * @return 生成的文件URL
     * @throws IOException 如果文件操作失败
     */
    public String storeFile(MultipartFile file, String prefix) throws IOException {
        // 获取真正的上传目录（JAR 所在路径/upload/img）
        Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();

        // 自动创建目录（如果不存在）
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 生成唯一文件名
        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileExtension = getFileExtension(originalFileName);
        String uniqueFileName = UUID.randomUUID() + fileExtension;

        // 保存文件
        Path filePath = uploadPath.resolve(uniqueFileName);
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error("❌ 存储文件失败: " + uniqueFileName, e);
            throw e;
        }

        // 返回访问路径
        String fileUrl;
        if (StringUtils.hasText(prefix)) {
            fileUrl = prefix + "/" + uniqueFileName;
        } else {
            fileUrl = PathUtil.getBaseUrl() + "/" + uniqueFileName;
        }

        return fileUrl;
    }

    /**
     * 删除文件
     *
     * @param fileUrl 文件URL
     * @return 删除是否成功
     */
    public boolean deleteFile(String fileUrl) {
        try {
            String fileName = getFileNameFromUrl(fileUrl);
            if (fileName == null) return false;

            Path filePath = Paths.get(PathUtil.getUploadImgPath()).resolve(fileName).normalize();
            return Files.deleteIfExists(filePath);
        } catch (IOException e) {
            log.error("❌ 删除文件失败: " + fileUrl, e);
            return false;
        }
    }

    public String getFileNameFromUrl(String fileUrl) {
        if (fileUrl == null) return null;
        return fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
    }

    public String getFileExtension(String fileName) {
        if (fileName == null) return "";
        int index = fileName.lastIndexOf(".");
        return index < 0 ? "" : fileName.substring(index);
    }
}
