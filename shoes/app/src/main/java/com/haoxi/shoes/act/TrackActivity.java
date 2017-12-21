package com.haoxi.shoes.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.haoxi.shoes.R;
import com.othershe.calendarview.bean.DateBean;
import com.othershe.calendarview.listener.OnPagerChangeListener;
import com.othershe.calendarview.listener.OnSingleChooseListener;
import com.othershe.calendarview.weiget.CalendarView;
import com.othershe.calendarview.weiget.WeekView;


public class TrackActivity extends AppCompatActivity {

    private static final String TAG = "TrackActivity";

    private WeekView weekView;
    private CalendarView calendarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        initView();
    }

    private void initView() {

        weekView = findViewById(R.id.weekView);
        calendarView = findViewById(R.id.calendar);
        //日历init
        calendarView
                .setStartEndDate("2010.7", "2018.12")
                .setInitDate("2017.12")
                .setSingleDate("2017.12.18")
                .init();

    //月份切换回调
        calendarView.setOnPagerChangeListener(new OnPagerChangeListener() {
            @Override
            public void onPagerChanged(int[] date) {
                Log.e(TAG,date[0]+"---"+date[1]+"---"+date[2]+"-------m");
                calendarView.setSingleDate("");
            }
        });

    //单选回调
//        calendarView.setOnItemClickListener(new OnMonthItemClickListener() {
//            @Override
//            public void onMonthItemClick(View view, DateBean date) {
//
//            }
//        });

        calendarView.setOnSingleChooseListener(new OnSingleChooseListener() {
            @Override
            public void onSingleChoose(View view, DateBean dateBean) {
                Log.e(TAG,dateBean.getSolar()[0]+"---"+dateBean.getSolar()[1]+"---"+dateBean.getSolar()[2]);
            }
        });
    }
}
