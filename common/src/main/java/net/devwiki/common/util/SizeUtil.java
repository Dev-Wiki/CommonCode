package net.devwiki.common.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 尺寸工具类
 * Created by DevWiki on 2016/8/7.
 */

public class SizeUtil {

    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static int px2dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    public static int px2sp(Context context, float px) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (px / fontScale + 0.5f);
    }

    public static int sp2px(Context context, float sp) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * fontScale + 0.5f);
    }

    public static DisplayMetrics getMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }
}
