package net.devwiki.common.util;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;

import net.devwiki.log.BuildConfig;
import net.devwiki.log.DevLog;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

/**
 * 文件工具类
 * Created by DevWiki on 016/8/7.
 */
public class FileUtil {

    /**
     * SD卡是否挂载
     *
     * @return true:挂载
     */
    public static boolean isSDMounted() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取SD根目录
     *
     * @return SD根目录且尾部带有"/"
     */
    public static String getSDRootPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    }

    /**
     * 获取下载文件夹
     *
     * @return 下载文件夹路径
     */
    public static String getDownloadDir() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                .getAbsolutePath() + File.separator;
    }

    /**
     * 文件是否存在
     *
     * @param path 文件路径
     * @return true:存在,false:不存在
     */
    public static boolean isExists(String path) {
        if (!isSDMounted()) {
            DevLog.w("sdcard is not mount!");
            return false;
        }
        if (TextUtils.isEmpty(path)) {
            DevLog.w("path is invalid!");
            return false;
        }
        return new File(path).exists();
    }

    /**
     * 创建文件或文件夹
     *
     * @param path 路径
     * @return true:创建成功
     */
    public static boolean createFile(String path) {
        if (!isSDMounted()) {
            DevLog.w("sdcard is not mount!");
            return false;
        }
        if (TextUtils.isEmpty(path)) {
            DevLog.w("path is invalid!");
            return false;
        }
        File file = new File(path);
        if (file.exists()) {
            DevLog.w("file is exists!");
            return false;
        }
        if (file.isDirectory()) {
            return file.mkdirs();
        } else {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /**
     * 删除文件
     *
     * @param path 文件路径
     * @return true:删除成功
     */
    public static boolean deleteFile(String path) {
        if (!isSDMounted()) {
            DevLog.w("sdcard is not mount!");
            return false;
        }
        if (TextUtils.isEmpty(path)) {
            DevLog.w("path is invalid!");
            return false;
        }
        File file = new File(path);
        if (!file.exists()) {
            DevLog.w("file is not exists!");
            return false;
        }
        if (file.isDirectory()) {
            DevLog.w("path is directory! please use deleteDir(String path)");
            return false;
        } else {
            return file.delete();
        }
    }

    /**
     * 删除文件夹,此操作可能耗时,建议在子线程调用
     *
     * @param path 文件路径
     * @return true:删除成功
     */
    public static boolean deleteDir(String path) {
        if (!isSDMounted()) {
            DevLog.w("sdcard is not mount!");
            return false;
        }
        if (TextUtils.isEmpty(path)) {
            DevLog.w("path is invalid!");
            return false;
        }
        File file = new File(path);
        if (!file.exists()) {
            DevLog.w("file is not exists!");
            return false;
        }
        if (file.isDirectory()) {
            deleteDir(file);
            return true;
        } else {
            DevLog.w("path is not directory!");
            return false;
        }
    }

    private static void deleteDir(File file) {
        File[] files = file.listFiles();
        if (files.length > 0) {
            for (File child : files) {
                if (child.isDirectory()) {
                    deleteDir(child);
                } else {
                    child.delete();
                }
            }
        } else {
            file.delete();
        }
    }

    /**
     * 获取SD卡空间大小,单位:B
     *
     * @return SD大小
     */
    public static long getSDSizeInByte() {
        if (isSDMounted()) {
            StatFs statFs = new StatFs(getSDRootPath());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
            } else {
                return statFs.getBlockSize() * statFs.getBlockCount();
            }
        } else {
            DevLog.w("sdcard is not mounted!");
            return 0L;
        }
    }

    /**
     * 获取SD空间大小,单位:KB
     *
     * @return SD大小
     */
    public static long getSDSizeInKB() {
        return getSDSizeInByte() / 1024;
    }

    /**
     * 获取SD空间大小,单位:MB
     *
     * @return SD大小
     */
    public static long getSDSizeInMB() {
        return getSDSizeInByte() / 1024 / 1024;
    }

    /**
     * 获取SD剩余空间大小,单位:B
     *
     * @return SD剩余大小
     */
    public static long getSDFreeSizeInByte() {
        if (isSDMounted()) {
            StatFs statFs = new StatFs(getSDRootPath());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                return statFs.getFreeBlocksLong() * statFs.getBlockSizeLong();
            } else {
                return statFs.getFreeBlocks() * statFs.getBlockSize();
            }
        } else {
            DevLog.w("sd is not mounted!");
            return 0L;
        }
    }

    /**
     * 获取SD剩余空间大小,单位:KB
     *
     * @return SD剩余大小
     */
    public static long getSDFreeSizeInKB() {
        return getSDFreeSizeInByte() / 1024;
    }

    /**
     * 获取SD剩余空间大小,单位:MB
     *
     * @return SD剩余大小
     */
    public static long getSDFreeSizeInMB() {
        return getSDFreeSizeInByte() / 1024 / 1024;
    }

    /**
     * 获取文件/文件夹的空间大小
     *
     * @param path 路径
     * @return 占用空间大小, 单位:B
     */
    public static long getSizeInByte(String path) {
        if (!isSDMounted()) {
            DevLog.w("sd is not mounted!");
            return 0L;
        }
        if (TextUtils.isEmpty(path)) {
            DevLog.w("path is invalid!");
            return 0L;
        }
        File file = new File(path);
        if (file.exists()) {
            return file.getTotalSpace();
        } else {
            DevLog.w("file is not exists!");
            return 0L;
        }
    }

    /**
     * 获取文件或路径空大小
     *
     * @param path 路经
     * @return 占用空间大小, 单位:KB
     */
    public static float getSizeInKB(String path) {
        long size = getSizeInByte(path);
        return 1.0F * size / 1024;
    }

    /**
     * 获取文件或路径空大小
     *
     * @param path 路经
     * @return 占用空间大小, 单位:MB
     */
    public static float getSizeInMB(String path) {
        long size = getSizeInByte(path);
        return 1.0F * size / 1024 / 1024;
    }
}