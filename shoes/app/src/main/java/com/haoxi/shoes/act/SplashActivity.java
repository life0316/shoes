package com.haoxi.shoes.act;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.haoxi.shoes.R;
import com.haoxi.shoes.utils.ApiUtils;

public class SplashActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (ApiUtils.isNetworkConnected(SplashActivity.this)) {
                    boolean isAutoCb = true;
                    Intent intent = null;
                    if (isAutoCb) {
                        intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                SplashActivity.this.finish();
            }
        }, 2000);
    }
}
