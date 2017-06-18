package com.mk.tjbnew.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mk.tjbnew.R;
import com.mk.tjbnew.fragment.DataFragment;
import com.mk.tjbnew.fragment.HomeFragment;
import com.mk.tjbnew.fragment.LifeFragment;
import com.mk.tjbnew.fragment.PersonalFragment;
import com.mk.tjbnew.util.L;


public class MainActivity extends BaseActivity{//AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment currentFragment;

    /** 体检Fragment */
    private HomeFragment homeFragment;
    /** 健康Fragment */
    private LifeFragment lifeFragment;
    /** 数据Fragment */
    private DataFragment dataFragment;
    /** 我的Fragment */
    private PersonalFragment personalFragment;

    /** 各个Fragment */
    private View tab_tijian, tab_data, tab_life, tab_personal;

    private ImageView tab_tijian_iv, tab_data_iv, tab_life_iv,
            tab_personal_iv;
    private TextView tab_tijian_tv, tab_data_tv, tab_life_tv,
            tab_personal_tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initFragment(tab_tijian);
    }

    public void initview() {
        tab_tijian = findViewById(R.id.tab_tijian);
        tab_data = findViewById(R.id.tab_data);
        tab_life = findViewById(R.id.tab_life);
        tab_personal = findViewById(R.id.tab_personal);
        tab_tijian_iv = (ImageView) findViewById(R.id.tab_tijian_iv);
        tab_data_iv = (ImageView) findViewById(R.id.tab_data_iv);
        tab_life_iv = (ImageView) findViewById(R.id.tab_life_iv);
        tab_personal_iv = (ImageView) findViewById(R.id.tab_personal_iv);
        tab_tijian_tv = (TextView) findViewById(R.id.tab_tijian_tv);
        tab_data_tv = (TextView) findViewById(R.id.tab_data_tv);
        tab_life_tv = (TextView) findViewById(R.id.tab_life_tv);
        tab_personal_tv = (TextView) findViewById(R.id.tab_personal_tv);
    }
    private void initFragment(View v) {
        if (v == null) {
            return;
        }

        if (fragmentManager == null) {
            fragmentManager = getFragmentManager();
        }
        transaction = fragmentManager.beginTransaction();
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }
        String tag = "tijian";
        if (v == tab_tijian) {
            tag = "tijian";
            if (homeFragment == null) {
                homeFragment = new HomeFragment();
                transaction.add(R.id.contentLayout, homeFragment, tag);
            } else {
                if (currentFragment != null) {
                    homeFragment = (HomeFragment) fragmentManager
                            .findFragmentByTag(tag);
                    transaction.show(homeFragment);
                }
            }
            currentFragment = homeFragment;
        } else if (v == tab_data) {
            tag = "data";
            if (dataFragment == null) {
                dataFragment = new DataFragment();
                transaction.add(R.id.contentLayout, dataFragment, tag);
            } else {
                if (currentFragment != null) {
                    dataFragment = (DataFragment) fragmentManager
                            .findFragmentByTag(tag);
                    transaction.show(dataFragment);
                }
            }
            currentFragment = dataFragment;
        } else if (v == tab_life) {
            tag = "life";
            if (lifeFragment == null) {
                lifeFragment = new LifeFragment();
                transaction.add(R.id.contentLayout, lifeFragment, tag);
            } else {
                if (currentFragment != null) {
                    lifeFragment = (LifeFragment) fragmentManager
                            .findFragmentByTag(tag);
                    transaction.show(lifeFragment);
                }
            }
            currentFragment = lifeFragment;
        } else if (v == tab_personal) {
            tag = "personal";
            if (personalFragment == null) {
                personalFragment = new PersonalFragment();
                transaction.add(R.id.contentLayout, personalFragment, tag);
            } else {
                if (currentFragment != null) {
                    personalFragment = (PersonalFragment) fragmentManager
                            .findFragmentByTag(tag);
                    transaction.show(personalFragment);
                }
            }
            currentFragment = personalFragment;
        }
        transaction.commit();
    }

    public void clickTab(View v) {

        L.d("v id ---" + v.getId());
        switch (v.getId()) {
            case R.id.tab_tijian:
                setChooseImageView(tab_tijian_iv,
                        R.drawable.home_tab_tijian_selected);
                setChooseTextView(tab_tijian_tv, Color.parseColor("#3b98fd"));
                initFragment(tab_tijian);
                break;
            case R.id.tab_data:
                setChooseImageView(tab_data_iv,
                        R.drawable.home_tab_data_selected);
                setChooseTextView(tab_data_tv, Color.parseColor("#3b98fd"));
                initFragment(tab_data);
                break;
            case R.id.tab_life:
                setChooseImageView(tab_life_iv, R.drawable.home_tab_life_selected);
                setChooseTextView(tab_life_tv, Color.parseColor("#3b98fd"));
                initFragment(tab_life);
                break;
            case R.id.tab_personal:
                setChooseImageView(tab_personal_iv,
                        R.drawable.home_tab_personal_selected);
                setChooseTextView(tab_personal_tv, Color.parseColor("#3b98fd"));
                initFragment(tab_personal);
                break;
        }
    }

    private void setChooseImageView(ImageView chooseImageView, int resId) {
        if (chooseImageView == null) {
            return;
        }
        tab_tijian_iv.setImageResource(R.drawable.home_tab_tijian_normal);
        tab_data_iv.setImageResource(R.drawable.home_tab_data_normal);
        tab_life_iv.setImageResource(R.drawable.home_tab_life_normal);
        tab_personal_iv.setImageResource(R.drawable.home_tab_personal_normal);
        chooseImageView.setImageResource(resId);
    }

    private void setChooseTextView(TextView chooseTextView, int resId) {
        if (chooseTextView == null) {
            return;
        }
        tab_tijian_tv.setTextColor(Color.parseColor("#c2c2c2"));
        tab_data_tv.setTextColor(Color.parseColor("#c2c2c2"));
        tab_life_tv.setTextColor(Color.parseColor("#c2c2c2"));
        tab_personal_tv.setTextColor(Color.parseColor("#c2c2c2"));
        chooseTextView.setTextColor(resId);
    }

}
