package com.cmfchina.dataportal.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {

    public String storeFile(MultipartFile file, String prefix)  throws IOException;

    public boolean deleteFile(String fileUrl);

    /**
     * 从URL中提取文件名
     *
     * @param fileUrl 文件URL
     * @return 文件名
     */
    public String getFileNameFromUrl(String fileUrl) ;

    /**
     * 获取文件扩展名
     *
     * @param fileName 文件名
     * @return 扩展名包括点(.)
     */
    public String getFileExtension(String fileName);
}
