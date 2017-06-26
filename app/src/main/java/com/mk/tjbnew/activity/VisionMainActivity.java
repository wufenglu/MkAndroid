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


public class VisionMainActivity extends BaseActivity{//AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
