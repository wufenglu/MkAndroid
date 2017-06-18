package com.mk.tjbnew.net;

public abstract class AbstractRequest implements RequestService {

	@Override
	public String callNetRequestPost(String param) {
		return null;
	}

	@Override
	public String callNetRequestGet(String requestUrl) {
		return null;
	}

	@Override
	public int getNetworkState() {
		return 0;
	}
}