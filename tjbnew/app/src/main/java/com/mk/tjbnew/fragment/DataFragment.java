package com.mk.tjbnew.fragment;

import android.annotation.SuppressLint;

import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mk.tjbnew.R;
import com.mk.tjbnew.util.L;

/**
 * 数据页fragment
 *
 */
@SuppressLint("NewApi")
public class DataFragment extends Fragment{
	
	 @Override  
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  
	        View view = inflater.inflate(R.layout.fragment_data, null);
//	        TextView tv = new TextView(getActivity());
//	        tv.setText(R.string.activity);
		 L.d("******************    数据Fragment页面   ********************" );
		 return view;
	    }  

}
