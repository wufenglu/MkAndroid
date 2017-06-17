package com.mk.tjbnew.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.mk.tjbnew.application.QYApplication;
import com.mk.tjbnew.dialog.MyProgressBar;
import com.mk.tjbnew.util.CommonUtil;
import com.mk.tjbnew.util.L;
import com.mk.tjbnew.util.Log;

//import com.alibaba.fastjson.JSONObject;
//import com.darling.baitiao.application.QYApplication;
//import com.darling.baitiao.dialog.MyProgressBar;
//import com.darling.baitiao.utils.CommonUtil;
//import com.darling.baitiao.utils.L;
//import com.darling.baitiao.utils.Log;
//import com.igexin.sdk.PushManager;
//import com.umeng.analytics.MobclickAgent;
//
//import cn.fraudmetrix.android.FMAgent;

/**
 * 基础类
 *
 */
public class BaseActivity extends Activity {
	
	/**公共的加载条*/
	public MyProgressBar progressDialog;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		progressDialog = new MyProgressBar(this);
		progressDialog.setCancelable(false);
		L.i("------size"+ QYApplication.getApplication().getActivityList().size());
		if(QYApplication.getApplication().getActivityList().size()==0){
			/*//个推1
	        Log.d("GetuiSdkDemo", "initializing sdk...");
			PushManager.getInstance().initialize(this.getApplicationContext());*/
//			L.i("---------PushManager"+PushManager.getInstance());
//			L.e("初始化，并获取cid:"+PushManager.getInstance().getClientid(this.getApplicationContext()));
			/*// 同盾科技
			FMAgent.init(this.getApplicationContext(), true);*/
			

			/*CommonUtil.getLocalIpAddress(this);*/
			
//			Context context = getApplicationContext();
//			XGPushManager.registerPush(context);
//			Intent service = new Intent(context, XGPushService.class);
//			context.startService(service);
		}
		QYApplication.getApplication().getActivityList().add(this);

	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		dismissProgressDialog();
		//移除画面
		QYApplication.getApplication().getActivityList().remove(this);
	}
	
	/**
	 * 显示滚动条
	 */
	public void showProgressDialog() {
		if (!progressDialog.isShowing()) {
			// progressDialog = ProgressDialog.show(this,
			// "拼命加载中......","请等待......", true, false);
			progressDialog.show();
		}
	}
	
	
	/**
	 * 显示滚动条
	 */
	public void showProgressDialog(boolean isCancelable) {
		if (!progressDialog.isShowing()) {
			// progressDialog = ProgressDialog.show(this,
			// "拼命加载中......","请等待......", true, false);
			progressDialog.setCancelable(isCancelable);
			progressDialog.show();
		}
	}
	
	/**
	 * 隐藏滚动条
	 */
	public void dismissProgressDialog() {
		if (progressDialog.isShowing()) {
			progressDialog.dismiss();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
//		MobclickAgent.onPause(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
//		MobclickAgent.onResume(this);

	}

//	/**
//	 * 公共的請求方法
//	 * @param url
//	 *
//	 */
//	public void doPost(String url) {
//
//	}
//
//
//
//	/**
//	 * 公共的请求成功方法
//	 * @param jsonObject:json中data字段的数据
//	 */
//	public void onSuccessRequest(JSONObject jsonObject) {
//
//	}
}
