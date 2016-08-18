package net.devwiki.common.util;

import java.util.Collection;

/**
 * 集合工具类
 * Created by DevWiki on 2016/8/18.
 */

public class CollectionUtil {

    /**
     * 集合是否null或者元素为空
     * @param collection 集合
     * @return true: null或者元素为空
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
