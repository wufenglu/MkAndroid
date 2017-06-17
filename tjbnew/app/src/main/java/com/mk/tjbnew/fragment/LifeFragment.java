package com.mk.tjbnew.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.mk.tjbnew.R;
import com.mk.tjbnew.util.L;


/**
 * 健康页fragment
 *
 */
@SuppressLint("NewApi")
public class LifeFragment extends Fragment implements OnClickListener {

	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_life, null);
		L.d("******************    健康Fragment页面   ********************" );
		return view;
	}

	@Override
	public void onClick(View view) {

	}
}
