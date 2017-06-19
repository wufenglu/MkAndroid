package com.mk.tjbnew.model;

import android.widget.ImageView;

/**
 * 首页功能模块实体类
 * Created by SuZiCompany on 2017/6/18.
 */

public class HomeItemfunctionModel {
    /** 功能图标 */
    public int functionIcon;
    /** 功能名称 */
    public String functionName;

    public int getFunctionIcon() {
        return functionIcon;
    }

    public void setFunctionIcon(int functionIcon) {
        this.functionIcon = functionIcon;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
}
