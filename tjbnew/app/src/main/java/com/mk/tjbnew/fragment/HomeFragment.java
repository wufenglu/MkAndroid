package com.mk.tjbnew.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mk.tjbnew.R;
import com.mk.tjbnew.util.L;


/**
 * 首页fragment
 *
 */
@SuppressLint("NewApi")
public class HomeFragment extends Fragment{
	 
	private Activity instance;
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  

	        View view = inflater.inflate(R.layout.activity_tab_home, null);
	        initView(view);
	        return view;
	    }  
	   private void initView(View view) {
		// TODO Auto-generated method stub
		   L.d("******************    体检Fragment页面   ********************" );
	   }

}
