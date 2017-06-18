package com.mk.tjbnew.net;

public abstract interface RequestService {

	/**
	 * Post请求网络
	 * 
	 * @param requestUrl
	 * @param param
	 * @return
	 */

	abstract String callNetRequestPost(String param);

	/**
	 * get请求网络
	 * 
	 * @param requestUrl
	 * @return
	 */
	abstract String callNetRequestGet(String requestUrl);

	/**
	 * 获取网络状态
	 * 
	 * @return
	 */
	public abstract int getNetworkState();

}
