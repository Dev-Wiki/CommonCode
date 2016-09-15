package net.devwiki.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * JSON工具类
 * Created by DevWiki on 2016/9/15.
 */

public class JsonUtil {

    private static Gson gson = new GsonBuilder()
            .create();

    public static String toJson(Object o) {
        return gson.toJson(o);
    }

    public static <T>T toObject(String json, Class<T> claxx) {
        return gson.fromJson(json, claxx);
    }

    public static <T>List<T> toList(String json) {
        Type type = new TypeToken<List<T>>(){}.getType();
        return gson.fromJson(json, type);
    }
}
