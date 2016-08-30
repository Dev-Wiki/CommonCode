package net.devwiki.common.util;

/**
 * 字符串工具类
 * Created by DevWiki on 2016/8/18.
 */

public class StringUtil {

    /**
     * 不为null并且长度大于0
     * @param data 字符串
     * @return true: 不为bull且length大于0
     */
    public static boolean isNotEmpty(String data) {
        return data != null && data.length() > 0;
    }
}
