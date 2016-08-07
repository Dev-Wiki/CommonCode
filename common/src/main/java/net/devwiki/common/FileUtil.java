package net.devwiki.common;

import android.text.TextUtils;

import java.io.File;

/**
 * 文件工具类
 * Created by DevWiki on 016/8/7.
 */
public class FileUtil {

    /**
     * 文件是否存在
     * @param path 文件路径
     * @return true:存在,false:不存在
     */
    public static boolean isExists(String path){
        return !TextUtils.isEmpty(path) && new File(path).exists();
    }

    /**
     * 获取文件/文件夹的空间大小
     * @param path 路径
     * @return 占用空间大小,单位:B
     */
    public static long getSizeInByte(String path){
        if (TextUtils.isEmpty(path)){
            return 0L;
        }
        File file = new File(path);
        return file.getTotalSpace();
    }

    /**
     * 获取文件或路径空大小
     * @param path 路经
     * @return 占用空间大小,单位:KB
     */
    public static float getSizeInKB(String path){
        long size = getSizeInByte(path);
        return 1.0F*size/1024;
    }

    /**
     * 获取文件或路径空大小
     * @param path 路经
     * @return 占用空间大小,单位:MB
     */
    public static float getSizeInMB(String path){
        long size = getSizeInByte(path);
        return 1.0F*size/(1024*1024);
    }
}