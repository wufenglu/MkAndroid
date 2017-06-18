package com.mk.tjbnew.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.mk.tjbnew.R;


public class MyProgressBar extends Dialog {


	public MyProgressBar(Context context) {
		this(context, R.style.MyDialog);
	}

	public MyProgressBar(Context context, int theme) {
		super(context, theme);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressdialog_layout);
//		this.setCancelable(false);
	}

}
