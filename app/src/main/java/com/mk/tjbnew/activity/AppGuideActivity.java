package com.mk.tjbnew.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

//import com.darling.baitiao.R;
//import com.darling.baitiao.adapter.ViewPageAdapter;

import com.mk.tjbnew.R;
import com.mk.tjbnew.adapter.ViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

/*启动*/
public class AppGuideActivity extends BaseActivity implements OnPageChangeListener {

    public ViewPager vp;
    public ViewPageAdapter vpAdapter;
    public List<View> views;

    // 底部小点图片
    public ImageView[] dots;

    // 记录当前选中位置
    public int currentIndex;

    @SuppressLint("NewApi")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.app_guide_activity);
        
        // 初始化页面
        initViews();

        // 初始化底部小点
        initDots();
//        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.argb(128, 0, 0, 0)));
    }

    public void initViews() {
        LayoutInflater inflater = LayoutInflater.from(this);

        views = new ArrayList<View>();
        // 初始化引导图片列表
//        views.add(inflater.inflate(R.layout.guide_first_view, null));
        views.add(inflater.inflate(R.layout.guide_two_view, null));
        views.add(inflater.inflate(R.layout.guide_three_view, null));
       views.add(inflater.inflate(R.layout.guide_four_view, null));
        // 初始化Adapter
        vpAdapter = new ViewPageAdapter(views, this);

        vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(vpAdapter);
        // 绑定回调
        vp.setOnPageChangeListener(this);
    }

    public void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);

        dots = new ImageView[views.size()];

        // 循环取得小点图片
        for (int i = 0; i < views.size(); i++) {
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setSelected(true);// 都设为灰色
        }

        currentIndex = 0;
        dots[currentIndex].setSelected(false);// 设置为白色，即选中状态
    }

    public void setCurrentDot(int position) {
        if (position < 0 || position > views.size() - 1
                || currentIndex == position) {
            return;
        }

        dots[position].setSelected(false);
        dots[currentIndex].setSelected(true);

        currentIndex = position;
    }

    // 当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    // 当当前页面被滑动时调用
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    // 当新的页面被选中时调用
    @Override
    public void onPageSelected(int arg0) {
        // 设置底部小点选中状态
        setCurrentDot(arg0);
    }
}