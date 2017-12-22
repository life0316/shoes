package com.haoxi.shoes.base;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

public class ShoesApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
