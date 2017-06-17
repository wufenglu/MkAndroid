package com.mk.tjbnew.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
//import android.provider.SyncStateContract;
//import android.support.multidex.MultiDex;

//import com.darling.baitiao.common.Constants;
//import com.darling.baitiao.utils.ChannelUtil;
//import com.darling.baitiao.utils.CommonUtil;
//import com.darling.baitiao.utils.L;
//import com.darling.baitiao.utils.Log;
//import com.easemob.chat.EMChat;
//import com.facebook.drawee.backends.pipeline.Fresco;
//import com.umeng.analytics.AnalyticsConfig;
//import com.umeng.analytics.MobclickAgent;

import com.mk.tjbnew.common.Constants;
import com.mk.tjbnew.util.CommonUtil;
import com.mk.tjbnew.util.L;
import com.mk.tjbnew.util.Log;
//import com.umeng.analytics.MobclickAgent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

//import easemob.helpdeskdemo.DemoHelper;


/**
 * 应用类
 */
public class QYApplication extends Application {

    /**
     * 运行页面的列表
     */
    private ArrayList<Activity> activityList;
    /**
     * application
     */
    public static QYApplication application;

    public static QYApplication getApplication () {
        return application;
    }

    public ArrayList<Activity> getActivityList () {
        return activityList;
    }

    public static Context context;


    /**
     * 整个应用程序都能获取的context
     */
    public static Context getContext () {
        return context;
    }

    @Override
    public void onCreate () {
        //检测重复的包
        //MultiDex.install(this);
        //MultiDex.install(this);//hys
        super.onCreate();

        context = getApplicationContext();
//        //初始化fresco
//        Fresco.initialize(this);
        L.i("-----app create");
        activityList = new ArrayList<Activity>();
        application = this;
        //初始化日志
        L.isDebug=true;
//        Log.initialize(this);
        getLocalVersion();
        //如果缓存位置文件不存在
        String cachePath = String.format("%s%s", CommonUtil.getSDPath(), Constants.CACHE_PATH);

        L.i("-------cachePath old" + cachePath);

        File destDir = new File(cachePath);
        if (! destDir.exists()) {
            destDir.mkdirs();
        }

        copyDataToSD(cachePath);
        copyDefaultProfileToSD(cachePath);

//        // init demo helper
//        DemoHelper.getInstance().init(context);

    }


    /**
     * 得到本地的版本
     *
     * @return 本地版本
     */
    public String getLocalVersion () {

        String localVersion = "";
        try {
            PackageInfo packageInfo = getApplicationContext()
                    .getPackageManager().getPackageInfo(getPackageName(), 0);
            localVersion = packageInfo.versionName;
        } catch (Exception e) {
        }
        return localVersion;
    }

    /**
     * 退出应用
     */
    public void exitApplication () {
        System.out.println("-----app exit");
        for (int i = 0; i < activityList.size(); i++) {
            activityList.get(i).finish();
        }
//        //友盟推送
//        MobclickAgent.onKillProcess(this);
//        // 关闭fresco（图片框架）
//        Fresco.shutDown();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    /**
     * 将asserts的文件拷贝到sd卡中
     *
     * @param strOutFileName
     */
    private void copyDataToSD (String strOutFileName) {
        try {
            InputStream myInput;
            myInput = this.getAssets().open("add_pic_btn.png");
            strOutFileName = String.format("%s/%s", strOutFileName, "add_pic_btn.png");
            OutputStream myOutput = new FileOutputStream(strOutFileName);
            byte[] buffer = new byte[1024];
            int length = myInput.read(buffer);
            while (length > 0) {
                myOutput.write(buffer, 0, length);
                length = myInput.read(buffer);
            }

            myOutput.flush();
            myInput.close();
            myOutput.close();
        } catch (Exception e) {

        }
    }

    private void copyDefaultProfileToSD (String strOutFileName) {
        try {
            InputStream myInput;
            myInput = this.getAssets().open("profile_default.png");
            strOutFileName = String.format("%s/%s", strOutFileName, "profile_default.png");
            OutputStream myOutput = new FileOutputStream(strOutFileName);
            byte[] buffer = new byte[1024];
            int length = myInput.read(buffer);
            while (length > 0) {
                myOutput.write(buffer, 0, length);
                length = myInput.read(buffer);
            }

            myOutput.flush();
            myInput.close();
            myOutput.close();
        } catch (Exception e) {
            L.i(e.toString());
        }
    }

  /*  //解决添加环信客服之后与友盟的冲突
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }*/

}
