package net.devwiki.common.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/**
 * 设备工具类
 * Created by DevWiki on 2016/8/17.
 */

public class DeviceUtil {

    /**
     * 获取Mac地址,需要权限:android.permission.ACCESS_WIFI_STATE
     *
     * @param context 上下文
     * @return MacAddress
     */
    public static String getMacAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        return wifiInfo == null ? null : wifiInfo.getMacAddress();
    }

    /**
     * 获取手机品牌
     *
     * @return Brand
     */
    public static String getPhoneBrand() {
        return Build.BRAND;
    }

    /**
     * 获取手机型号
     *
     * @return Model
     */
    public static String getPhoneModel() {
        return Build.MODEL;
    }

    /**
     * 获取Android版本号
     *
     * @return System Version Code
     */
    public static int getSystemVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 获取Android版本名称
     *
     * @return System Version Name
     */
    public static String getSystemVersionName() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取手机IMEI,需要权限:android.permission.READ_PHONE_STATE
     *
     * @param context 上下文
     * @return IMEI
     */
    public static String getIMEI(Context context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return manager.getDeviceId();
    }

    /**
     * 获取手机IMSI,需要权限:android.permission.READ_PHONE_STATE
     *
     * @param context 上下文
     * @return IMSI
     */
    public static String getIMSI(Context context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return manager.getSubscriberId();
    }

    /**
     * 获取手机号码,需要权限:android.permission.READ_PHONE_STATE
     *
     * @param context 上下文
     * @return Phone Number
     */
    public static String getPhoneNumber(Context context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return manager.getLine1Number();
    }
}
