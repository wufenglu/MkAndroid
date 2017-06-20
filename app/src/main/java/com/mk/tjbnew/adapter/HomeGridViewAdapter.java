package com.mk.tjbnew.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.mk.tjbnew.R;
import com.mk.tjbnew.model.HomeItemfunctionModel;

import java.util.ArrayList;

/**
 * 功能列表适配器
 * TODO: document your custom view class.
 */
public class HomeGridViewAdapter extends BaseAdapter {

    LayoutInflater inflater = null;
    ArrayList<HomeItemfunctionModel> homeItemfunctionModelArrayList;

    public HomeGridViewAdapter(Context context, ArrayList<HomeItemfunctionModel> homeItemfunctionModelArrayList) {
        inflater = LayoutInflater.from(context);
//        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.homeItemfunctionModelArrayList = homeItemfunctionModelArrayList;
    }

    @Override
    public int getCount() {
        return homeItemfunctionModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return homeItemfunctionModelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertView == null || convertView.getTag() == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.home_grid_item, null);
            convertView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//            convertView = inflater.inflate(R.layout.home_grid_item, viewGroup, false);

            holder.iv_function_icon = (ImageView) convertView.findViewById(R.id.iv_function_icon);
            holder.tv_function_name = (TextView) convertView.findViewById(R.id.tv_function_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        HomeItemfunctionModel homeItemfunctionModel = homeItemfunctionModelArrayList.get(i);
        holder.iv_function_icon.setImageResource(homeItemfunctionModel.functionIcon);
        holder.tv_function_name.setText(homeItemfunctionModel.getFunctionName());
        return convertView;
    }

    public class  ViewHolder {
        /** 功能图标 */
        ImageView iv_function_icon;
        /** 功能列表 */
        TextView tv_function_name;
    }

}
