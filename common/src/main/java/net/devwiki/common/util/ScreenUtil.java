package net.devwiki.common.util;

import android.content.Context;

/**
 * 屏幕工具
 * Created by DevWiki on 2016/8/7.
 */

public class ScreenUtil {

    /**
     * 获取屏幕宽度
     *
     * @param context 上下文
     * @return width px
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param context 上下文
     * @return height px
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 获取DensityDpi
     *
     * @param context 上下文
     * @return DensityDpi
     */
    public static int getDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    /**
     * 获取Density
     *
     * @param context 上下文
     * @return Density
     */
    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /**
     * 获取ScaledDensity
     *
     * @param context 上下文
     * @return ScaledDensity
     */
    public static float getScaledDensity(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }
}
