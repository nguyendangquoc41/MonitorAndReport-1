package com.example.mjho1.monitorandreport.Class;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

import static android.content.Context.WIFI_SERVICE;

/**
 * Created by Nam Hoang Nguyen on 26/05/2016.
 */
public class Consts {

    public static final String TAG = Consts.class.getSimpleName();

    public static final String KEY_OTP_AUTHENTICATION = "KEY_OTP_AUTHENTICATION";

    public static int clientSeq = 1;//Temp auto create
    public static final String secCode = "999";
    public static final String clientVersion = "1.0.0";
    public static final String MdmTp = "03";
    public static final String MW_LOGIN_ID = "Android";
    public static final String MW_LOGIN_PSWD = "AdOirSSli@A*/@Mld";
    public static final int TIMEOUT_SECOND = 15;

    public static String getIpAddress(Context context){
        WifiManager wifiMgr = (WifiManager) context.getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
        int ip = wifiInfo.getIpAddress();
        String ipAddress = Formatter.formatIpAddress(ip);
        return  ipAddress;
    }
}
