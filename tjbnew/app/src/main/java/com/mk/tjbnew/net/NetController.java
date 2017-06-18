package com.mk.tjbnew.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.text.TextUtils;

import com.mk.tjbnew.activity.BaseActivity;
import com.mk.tjbnew.util.L;

public class NetController extends AbstractRequest {
	private Context context;
	private int timeout = 20000;
	private String result;
	private Thread thread;
	private String url;

	public NetController(Context context) {
		this.context = context;
//		this.url = UrlType.ENMURL;
		// this.url = "http://172.20.16.126/api/service";
	}

	/**
	 * 同步请求数据
	 * 
	 * @param requestUrl
	 *            请求网络接口 eg: UrlType.LOGIN
	 * @param methodName
	 * @param param
	 * @param isTips
	 *            能否关闭loading
	 * @return
	 */
	public String syncCallNetRequest(String param, boolean isTips) {
		syncLoadingController(true, isTips);
		String result = callNetRequestPost(param);
		syncLoadingController(false, isTips);
		return result;
	}

	/**
	 * 同步 关闭网络
	 * 
	 * @param t
	 */
	public static void syncStopThread(Thread t) {
		t.interrupt();
	}

	private void syncLoadingController(final boolean flag, boolean isTips) {
		((BaseActivity) context).runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (flag) {
					// ((BaseActivity)context.showLoading(isTips));
				} else {
					// ((BaseActivity)context.stopLoading());

				}
			}
		});

	}

	public String asyncCallNetRequest(final String param, boolean isTips) {
		result = "";
		// ((BaseActivity)context.showLoading(isTips));
		thread = new Thread(new Runnable() {

			@Override
			public void run() {
				result = callNetRequestPost(param);
			}
		});
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			L.d("异常捕获===" + e);
		}
		// ((BaseActivity)context.stopLoading());
		return result;

	}

	public void syncStopThread() {
		thread.interrupt();
	}

	@Override
	public String callNetRequestPost(String param) {
		if (TextUtils.isEmpty(url))
			L.d("ERROR：未初始化环境");
		L.d("请求参数===="+param);
		String result = "";
		BufferedReader read = null;
		PrintWriter pw = null;
		try {
			URL realurl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) realurl
					.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.connect();
			pw = new PrintWriter(conn.getOutputStream());
			pw.write(param);
			pw.flush();
			int responseCode = conn.getResponseCode();
			if (responseCode != 200) {
				L.d(" Error===" + responseCode);
			} else {
				L.d("Post Success!");
			}
			read = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			String line;// 循环读取
			while ((line = read.readLine()) != null) {
				result += line;
			}
			L.d("返回数据===="+result);
		} catch (MalformedURLException e) {
			L.d("异常捕获===" + e);

		} catch (IOException e) {
			L.d("异常捕获===" + e);
		} finally {
			if (read != null) {// 关闭流
				try {
					read.close();
				} catch (IOException e) {
					L.d("异常捕获===" + e);
				}
			}
			if (pw != null) {
				pw.close();
			}

		}
		return result;
	}

	@Override
	public String callNetRequestGet(String requestUrl) {
		return super.callNetRequestGet(requestUrl);
	}

	// private String analyzeData(JsonObject data){}
}
