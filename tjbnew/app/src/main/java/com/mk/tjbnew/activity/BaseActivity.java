package com.mk.tjbnew.activity;

import android.app.Activity;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.mk.tjbnew.application.QYApplication;
import com.mk.tjbnew.dialog.MyProgressBar;
import com.mk.tjbnew.net.NetController;
import com.mk.tjbnew.receiver.NetworkReceiver;
import com.mk.tjbnew.receiver.NetworkReceiver.NetworkListener;
import com.mk.tjbnew.util.L;


/**
 * 基础类
 *
 */
public class BaseActivity extends Activity implements NetworkListener {
	
	/**公共的加载条*/
	public MyProgressBar progressDialog;

	/**
	 * 网络状态监听类
	 */
	public NetworkReceiver netReceiver;
	public BaseActivity instance;
	public NetController netcontroller;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		progressDialog = new MyProgressBar(this);
		progressDialog.setCancelable(false);
		L.i("------size"+ QYApplication.getApplication().getActivityList().size());
		QYApplication.getApplication().getActivityList().add(this);
		netReceiver = new NetworkReceiver();
		netReceiver.setNetworkListener(this);
		netcontroller = new NetController(instance);
		registerReceiver(netReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));

	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		dismissProgressDialog();
		//移除画面
		QYApplication.getApplication().getActivityList().remove(this);
		unregisterReceiver(netReceiver);
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

	@Override
	public void NetworkChanged(boolean isConnected) {

	}

}
