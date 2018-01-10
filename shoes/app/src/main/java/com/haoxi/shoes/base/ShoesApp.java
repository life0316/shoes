package com.haoxi.shoes.base;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.haoxi.shoes.bluetooth.BluetoothLeService;
import com.haoxi.shoes.retrofit.RetrofitManager;

public class ShoesApp extends Application {

    private static ShoesApp app;
    private BluetoothLeService bluetoothLeService;

    public static ShoesApp getInstance(){
        return app;
    }

    public BluetoothLeService getBluetoothLeService(){
        return bluetoothLeService;
    }

    public void setBluetoothLeService(BluetoothLeService bluetoothLeService){
        this.bluetoothLeService = bluetoothLeService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Utils.init(this);
        RetrofitManager.initRetrofit();
    }
}
