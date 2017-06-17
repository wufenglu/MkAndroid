package com.mk.tjbnew.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 
 * 网络监听广播类
 *
 */
public class NetworkReceiver extends BroadcastReceiver {
	
	public NetworkListener networklistener;
    @Override  
    public void onReceive(Context context, Intent intent) {  
        // TODO Auto-generated method stub  
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);  
        NetworkInfo activeInfo = manager.getActiveNetworkInfo();  
       
        if (activeInfo == null) {
        	networklistener.NetworkChanged(false);
        } else {
        	networklistener.NetworkChanged(true);
        }
    }  
    
    public interface NetworkListener {
        public void NetworkChanged(boolean isConnected);
    }
    
    public void setNetworkListener (NetworkListener networklistner) {
    	this.networklistener = networklistner;
    }
   
}  
