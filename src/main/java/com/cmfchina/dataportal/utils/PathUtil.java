package com.cmfchina.dataportal.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class PathUtil {

    /**
     * 获取 JAR 包所在目录；如果在 IDE 中运行，则返回项目根目录
     */
    public static String getRootDir() {
        try {
            File jarFile = new File(PathUtil.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI());

            File dir = jarFile.getParentFile();

            // 如果是开发环境，jarFile 是 classes 目录；回退到项目根路径（target 的上一级）
            if (dir.getAbsolutePath().contains("target")) {
                return Paths.get(dir.getAbsolutePath()).getParent().getParent().toString();
            }

            return dir.getAbsolutePath();

        } catch (URISyntaxException e) {
            throw new RuntimeException("无法获取运行目录", e);
        }
    }

    public static String getProjectDir() {
        try {
            File codeSource = new File(PathUtil.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI());

            String path = codeSource.getAbsolutePath();

            // 如果是 JAR 包运行，返回 jar 的所在目录
            if (path.endsWith(".jar")) {
                return codeSource.getParentFile().getAbsolutePath();
            }

            // IDE 模式（classes），回退两级到项目根目录
            return Paths.get(codeSource.getParentFile().getParentFile().getParent()).toString();

        } catch (Exception e) {
            throw new RuntimeException(" 无法获取项目目录", e);
        }
    }

    public static String getUploadImgPath() {
//        return Paths.get(getRootDir(), "upload", "img").toString();
        return Paths.get(getProjectDir(), "upload", "img").toString();
    }

    public static String getBaseUrl() {
        return "/img";
    }

    public static void main(String[] args) {
        String uploadImgPath = getUploadImgPath();
        System.out.println(uploadImgPath);

    }
}
