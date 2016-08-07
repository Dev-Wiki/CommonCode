package net.devwiki.common.util;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Toast工具
 * Created by DevWiki on 2016/8/7.
 */

public class ToastUtil {

    /**
     * 显示短时间的Toast
     * @param context 上下文
     * @param msg 消息
     */
    public static void showShort(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示短时间的Toast
     * @param context 上下文
     * @param resId 消息资源id
     */
    public static void showShort(Context context, @StringRes int resId) {
        Toast.makeText(context, context.getString(resId), Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示长时间的Toast
     * @param context 上下文
     * @param msg 消息
     */
    public static void showLong(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 显示长时间的Toast
     * @param context 上下文
     * @param resId 消息资源id
     */
    public static void showLong(Context context, @StringRes int resId) {
        Toast.makeText(context, context.getString(resId), Toast.LENGTH_LONG).show();
    }
}
