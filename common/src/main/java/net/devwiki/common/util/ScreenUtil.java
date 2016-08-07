package net.devwiki.common.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 屏幕工具
 * Created by zyz on 2016/8/7.
 */

public class ScreenUtil {

    public static int getScreenWidth(Context context) {
        return getMetrics(context).widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return getMetrics(context).heightPixels;
    }

    public static int getDensityDpi(Context context) {
        return getMetrics(context).densityDpi;
    }

    public static float getDensity(Context context) {
        return getMetrics(context).density;
    }

    public static float getScaledDensity(Context context) {
        return getMetrics(context).scaledDensity;
    }

    public static DisplayMetrics getMetrics(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }
}
