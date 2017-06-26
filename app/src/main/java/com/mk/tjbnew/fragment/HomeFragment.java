package com.mk.tjbnew.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.mk.tjbnew.R;
import com.mk.tjbnew.activity.vision.MainActivity;
import com.mk.tjbnew.adapter.HomeGridViewAdapter;
import com.mk.tjbnew.model.HomeItemfunctionModel;
import com.mk.tjbnew.view.DoughnutView;
import com.mk.tjbnew.view.HomeFunctionGridView;

import java.util.ArrayList;


/**
 * 首页fragment
 */
@SuppressLint("NewApi")
public class HomeFragment extends Fragment {


    public Activity instance;
    public HomeFunctionGridView homeFunctionGridView;
    /**
     * 功能列表List
     */
    public ArrayList<HomeItemfunctionModel> homeItemfunctionModelArrayList;
    /**
     * 功能列表适配器
     */
    public HomeGridViewAdapter homeGridViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_tab_home, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        instance = getActivity();
        initFunctionList();
        homeFunctionGridView = (HomeFunctionGridView) view.findViewById(R.id.gv_home_function);
        homeGridViewAdapter = new HomeGridViewAdapter(instance, homeItemfunctionModelArrayList);
        homeFunctionGridView.setAdapter(homeGridViewAdapter);
        ((DoughnutView) view.findViewById(R.id.doughnutView)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), MainActivity.class);
                startActivity(intent);
                //Toast.makeText(instance, "点击了快速体检按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initFunctionList() {
        homeItemfunctionModelArrayList = new ArrayList<HomeItemfunctionModel>();
        int[] function_icons = new int[]{R.drawable.ic1_digest, R.drawable.ic2_travel, R.drawable.ic3_cheats, R.drawable.ic4_house_keeping,
                R.drawable.ic5_expert, R.drawable.ic6_shopping_center, R.drawable.ic7_looking_for_doctor, R.drawable.ic8_call};
        String[] function_names = getResources().getStringArray(R.array.function_name);
        for (int i = 0; i < function_icons.length; i++) {
//            Map<int, String> map = new HashMap<int, String>();
            HomeItemfunctionModel homeItemfunctionModel = new HomeItemfunctionModel();
            homeItemfunctionModel.setFunctionIcon(function_icons[i]);
            homeItemfunctionModel.setFunctionName(function_names[i]);
            homeItemfunctionModelArrayList.add(homeItemfunctionModel);
        }

    }


}
