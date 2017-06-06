package com.cws.alarm.util;

import com.jfinal.kit.PathKit;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 上传工具类
 * Created by Can on 2015/4/25.
 */
public class UploadUtils {

    /**
     * 获取日期目录<br>
     * 例：/201502/23/
     *
     * @return
     */
    public static String getDateDirectory() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("/yyyyMM/dd/");
        return format.format(date);
    }


    /**
     * 获取文件扩展名<br>
     * 例：jpg or gif
     *
     * @param filePath
     * @return
     */
    public static String getFileExtName(String filePath) {
        int idx = filePath.lastIndexOf(".");
        if (idx == -1) return "";
        String extName = filePath.substring(idx + 1);
        return extName;
    }

    /**
     * 路径添加
     *
     * @param path
     * @param subPath
     */
    public static void pathAdd(StringBuffer path, String subPath) {
        if (path.length() == 0) {
            path.append(subPath);
            return;
        }
        String lastWord = path.substring(path.length() - 1, path.length());
        if (lastWord.equals("/") && subPath.startsWith("/")) {
            path.deleteCharAt(path.length() - 1).append(subPath);
        } else if (lastWord.equals("/") && !subPath.startsWith("/")) {
            path.append(subPath);
        } else if (!lastWord.equals("/") && subPath.startsWith("/")) {
            path.append(subPath);
        } else {
            path.append("/").append(subPath);
        }
    }

    /**
     * 绝对路径转可访问的URL地址
     *
     * @param absolutePath
     * @return
     */
    public static String absolutePathToUrl(String absolutePath) {
        return absolutePath.replace(PathKit.getWebRootPath(), "").replace("\\", "/");
    }

    /**
     * 相对路径转绝对路径
     *
     * @param url
     * @return
     */
    public static String urlToAbsolutePath(String url) {
        StringBuffer path = new StringBuffer(PathKit.getWebRootPath());
        pathAdd(path, url);
        return path.toString();
    }
}
