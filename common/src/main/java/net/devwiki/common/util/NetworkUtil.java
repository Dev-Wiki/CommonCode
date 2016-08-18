package net.devwiki.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;

/**
 * 网络工具
 * <p>网络相关的权限:</p>
 * <p>获取网络状态 : android.permission.ACCESS_NETWORK_STATE</p>
 * <p>需添加权限 android.permission.ACCESS_NETWORK_STATE</p>
 * Created by DevWiki on 2016/8/10.
 */

public class NetworkUtil {

    public static final int NETWORK_WIFI = 1;
    public static final int NETWORK_4G = 4;
    public static final int NETWORK_3G = 3;
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_UNKNOWN = 5;
    public static final int NETWORK_NO = -1;

    private static final int NETWORK_TYPE_GSM = 16;
    private static final int NETWORK_TYPE_TD_SCDMA = 17;
    private static final int NETWORK_TYPE_IWLAN = 18;

    /**
     * 打开网络设置界面
     * <p>3.0以下打开设置界面</p>
     *
     * @param activity 上下文
     */
    public static void openNetworkSettings(Activity activity) {
        if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
            activity.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
        } else {
            activity.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
        }
    }

    /**
     * 获取活动网路信息
     *
     * @param context 上下文
     * @return NetworkInfo
     */
    private static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    /**
     * 判断网络是否可用
     */
    public static boolean isAvailable(Context context) {
        NetworkInfo info = getActiveNetworkInfo(context);
        return info != null && info.isAvailable();
    }

    /**
     * 判断网络是否连接
     *
     * @param context 上下文
     * @return true: 是<br>false: 否
     */
    public static boolean isConnected(Context context) {
        NetworkInfo info = getActiveNetworkInfo(context);
        return info != null && info.isConnected();
    }

    /**
     * 判断网络是否是4G
     *
     * @param context 上下文
     * @return true: 是<br>false: 不是
     */
    public static boolean is4G(Context context) {
        NetworkInfo info = getActiveNetworkInfo(context);
        return info != null && info.isAvailable() && info.getSubtype() == TelephonyManager.NETWORK_TYPE_LTE;
    }

    /**
     * 判断wifi是否连接状态
     *
     * @param context 上下文
     * @return true: 连接<br>false: 未连接
     */
    public static boolean isWifiConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm != null && cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * 获取移动网络运营商名称,如中国联通、中国移动、中国电信
     *
     * @param context 上下文
     * @return 移动网络运营商名称
     */
    public static String getNetworkOperatorName(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null ? tm.getNetworkOperatorName() : null;
    }

    /**
     * 获取移动终端类型
     *
     * @param context 上下文
     * @return 手机制式
     * <ul>
     * <li>PHONE_TYPE_NONE: 0 手机制式未知</li>
     * <li>PHONE_TYPE_GSM : 1 手机制式为GSM，移动和联通</li>
     * <li>PHONE_TYPE_CDMA : 2 手机制式为CDMA，电信</li>
     * <li>PHONE_TYPE_SIP : 3</li>
     * </ul>
     */
    public static int getPhoneType(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null ? tm.getPhoneType() : -1;
    }


    /**
     * 获取当前的网络类型(WIFI,2G,3G,4G)
     *
     * @param context 上下文
     * @return 网络类型
     * <li>1: {@link NetworkUtil#NETWORK_WIFI}</li>
     * <li>2: {@link NetworkUtil#NETWORK_2G}</li>
     * <li>3: {@link NetworkUtil#NETWORK_3G}</li>
     * <li>4: {@link NetworkUtil#NETWORK_4G}</li>
     * <li>5: {@link NetworkUtil#NETWORK_UNKNOWN}</li>
     * <li>-1: {@link NetworkUtil#NETWORK_NO}</li>
     */
    public static int getNetWorkType(Context context) {
        int netType = NETWORK_NO;
        NetworkInfo info = getActiveNetworkInfo(context);
        if (info != null && info.isAvailable()) {

            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                netType = NETWORK_WIFI;
            } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                switch (info.getSubtype()) {

                    case NETWORK_TYPE_GSM:
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                    case TelephonyManager.NETWORK_TYPE_IDEN:
                        netType = NETWORK_2G;
                        break;

                    case NETWORK_TYPE_TD_SCDMA:
                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                    case TelephonyManager.NETWORK_TYPE_HSUPA:
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                    case TelephonyManager.NETWORK_TYPE_EVDO_B:
                    case TelephonyManager.NETWORK_TYPE_EHRPD:
                    case TelephonyManager.NETWORK_TYPE_HSPAP:
                        netType = NETWORK_3G;
                        break;

                    case NETWORK_TYPE_IWLAN:
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        netType = NETWORK_4G;
                        break;
                    default:

                        String subtypeName = info.getSubtypeName();
                        if (subtypeName.equalsIgnoreCase("TD-SCDMA")
                                || subtypeName.equalsIgnoreCase("WCDMA")
                                || subtypeName.equalsIgnoreCase("CDMA2000")) {
                            netType = NETWORK_3G;
                        } else {
                            netType = NETWORK_UNKNOWN;
                        }
                        break;
                }
            } else {
                netType = NETWORK_UNKNOWN;
            }
        }
        return netType;
    }

    /**
     * 获取当前的网络类型(WIFI,2G,3G,4G)
     *
     * @param context 上下文
     * @return 网络类型名称
     * <li>WiFi   </li>
     * <li>4G     </li>
     * <li>3G     </li>
     * <li>2G     </li>
     * <li>UNKNOWN</li>
     * <li>NO     </li>
     */
    public static String getNetWorkTypeName(Context context) {
        switch (getNetWorkType(context)) {
            case NETWORK_WIFI:
                return "WiFi";
            case NETWORK_4G:
                return "4G";
            case NETWORK_3G:
                return "3G";
            case NETWORK_2G:
                return "2G";
            case NETWORK_NO:
                return "NO";
            default:
                return "UNKNOWN";
        }
    }
}