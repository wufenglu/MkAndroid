package com.mk.tjbnew.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.mk.tjbnew.R;
import com.mk.tjbnew.util.L;


/**
 * 个人页fragment
 *
 */
@SuppressLint("NewApi")
public class PersonalFragment extends Fragment implements OnClickListener {

	private View view;
	private Activity instance;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_personal, null);
		instance = getActivity();

		initView();
		return view;
	}

	private void initView() {
		// initListener(R.id.xianjinbao);
		L.d("******************    我的Fragment页面   ********************" );
	}


	private void initListener(int id) {
		view.findViewById(id).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
//		final Intent intent = new Intent();
//		switch (v.getId()) {
//		case R.id.xianjinbao:
//			// startActivity(PhonePayActivity.class);
//			Toast.makeText(getActivity(), "现金宝", 0).show();
//			break;
//		}

	}

}
