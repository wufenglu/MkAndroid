package com.mk.tjbnew.util;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;

import com.mk.tjbnew.application.QYApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Created by Administrator on 2017/6/13.
 */

public class CommonUtil {

    /**
     * 获得sd卡根路径
     *
     * @return
     */
    public static String getSDPath() {
        String sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED); // 判断sd卡是否存在

        getStoragePathFromRemovale(QYApplication.getApplication(), false);
        if (sdCardExist) // 如果SD卡存在，则获取跟目录
        {
            L.i("-----has sd card");
            sdDir = Environment.getExternalStorageDirectory().toString();// 获取跟目录
        } else {
            L.i("-----no sd card");

            sdDir = getTFCardPath();
        }
        return sdDir.toString();
    }


    /**
     * 参数 is_removable为false时得到的是内置sd卡路径，为true则为外置sd卡路径
     *
     * @param mContext
     * @param is_removale
     * @return
     */
    private static String getStoragePathFromRemovale(Context mContext, boolean is_removale) {

        StorageManager mStorageManager = (StorageManager) mContext.getSystemService(Context.STORAGE_SERVICE);
        Class<?> storageVolumeClazz = null;
        try {
            storageVolumeClazz = Class.forName("android.os.storage.StorageVolume");
            Method getVolumeList = mStorageManager.getClass().getMethod("getVolumeList");
            Method getPath = storageVolumeClazz.getMethod("getPath");
            Method isRemovable = storageVolumeClazz.getMethod("isRemovable");
            Object result = getVolumeList.invoke(mStorageManager);
            final int length = Array.getLength(result);
            System.out.println("----length---" + length);
            for (int i = 0; i < length; i++) {
                Object storageVolumeElement = Array.get(result, i);
                String path = (String) getPath.invoke(storageVolumeElement);
                boolean removable = (Boolean) isRemovable.invoke(storageVolumeElement);
                if (is_removale == removable) {
                    return path;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTFCardPath() {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec("mount");
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            String line;
            String mount = new String();
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                if (line.contains("secure")) continue;
                if (line.contains("asec")) continue;

                if (line.contains("fat")) {
                    String columns[] = line.split(" ");
                    if (columns != null && columns.length > 1) {
                        mount = mount.concat("*" + columns[1] + "\n");
                    }
                } else if (line.contains("fuse")) {
                    String columns[] = line.split(" ");
                    if (columns != null && columns.length > 1) {
                        mount = mount.concat(columns[1] + "\n");
                    }
                }
            }
            return mount;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

//
//    public static void getLocalIpAddress(final Context context) {
//        try {
//            String address = "http://ip.taobao.com/service/getIpInfo2.php?ip=myip";
//            RequestHandler business = new RequestHandler((Activity) context, false);
//            business.request(new ICallBack() {
//
//                @Override
//                public void displayResult(int status, String data) {
//                    JSONObject jsonObject;
//                    try {
//                        jsonObject = new JSONObject(data);
//                        String code = jsonObject.getString("code");
//                        if (code.equals("0")) {
//                            JSONObject ipInfo = jsonObject.getJSONObject("data");
//                            String IP = ipInfo.getString("ip");
//                            System.out.println("----ip" + IP);
//                            SharePreferUtil.putString(context, "ip", IP);
//                        }
//                    } catch (JSONException e) {
//                        Log.e("提示", "获取IP地址时出现异常，异常信息是：" + e.toString());
//                    }
//                }
//
//            }, address);
//
//        } catch (Exception e) {
//            Log.e("提示", "获取IP地址时出现异常，异常信息是：" + e.toString());
//        }
//    }

    public static String getIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()
                            && inetAddress instanceof Inet4Address) {
                        // if (!inetAddress.isLoopbackAddress() && inetAddress
                        // instanceof Inet6Address) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
