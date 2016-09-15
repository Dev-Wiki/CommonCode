package net.devwiki.common.util;

import java.util.UUID;

/**
 * UUID 工具
 * Created by DevWiki on 2016/8/30.
 */

public class UUIDUtil {

    /**
     * 获取UUID,去除"-"
     * @return 32位UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
