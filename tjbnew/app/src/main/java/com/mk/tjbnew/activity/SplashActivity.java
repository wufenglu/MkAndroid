package com.mk.tjbnew.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.mk.tjbnew.R;
import com.mk.tjbnew.util.L;
import com.mk.tjbnew.util.SharePreferUtil;

//import com.darling.baitiao.R;
//import com.darling.baitiao.ShoppingMainActivity;
//import com.darling.baitiao.utils.SharePreferUtil;

/**
 * 启动页面
 * @author haochen
 *
 */
public class SplashActivity extends BaseActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//全屏
		getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
				WindowManager.LayoutParams. FLAG_FULLSCREEN);
		setContentView(R.layout.splash_activity);
		initView();
	}

	public void initView() {
		L.d("启动引导页");
		L.i("启动引导页2");
		//图标的放大及渐变效果
		ImageView splash=(ImageView) findViewById(R.id.splash_image);
		View view = findViewById(R.id.splash_bg);
		AlphaAnimation alphaAnim = new AlphaAnimation(1.0f, 1.0f);
		alphaAnim.setDuration(2500);
//		view.startAnimation(alphaAnim);
		Animation animation =AnimationUtils.loadAnimation(this, R.anim.alpha_scale_translate); 
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				arg0.setFillAfter(true);
				//跳转
//				String token = SharePreferUtil.getString(SplashActivity.this, "token");
				boolean isFirstIn = SharePreferUtil.getBoolean(SplashActivity.this,"isFirstIn", true);

				if(isFirstIn){
					Intent intent = new Intent(SplashActivity.this, AppGuideActivity.class);
					SplashActivity.this.startActivity(intent);
				}else
				/*if(CommonUtil.isExistValue(token)){
//					Intent intent = new Intent(SplashActivity.this,MainActivity.class);
					Intent intent = new Intent(SplashActivity.this,ShoppingMainActivity.class);
					SplashActivity.this.startActivity(intent);
				}else*/{
//					Intent intent = new Intent(SplashActivity.this,LoginActivity.class);//原来的为登录界面
					Intent intent = new Intent(SplashActivity.this, MainActivity.class);
					SplashActivity.this.startActivity(intent);
				}
                overridePendingTransition(R.anim.left_in, R.anim.left_out);  
                SplashActivity.this.finish();
                

			}
		});
		splash.setAnimation(animation);  
		
	}
	
	

}
