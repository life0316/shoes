package com.haoxi.shoes.act;

import android.support.annotation.NonNull;
import android.util.Log;

import com.haoxi.shoes.R;
import com.haoxi.shoes.base.BaseActivity;
import com.haoxi.shoes.utils.ActivityFragmentInject;
import com.haoxi.shoes.widget.materialcalendarview.CalendarDay;
import com.haoxi.shoes.widget.materialcalendarview.MaterialCalendarView;
import com.haoxi.shoes.widget.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;


@ActivityFragmentInject(contentViewId = R.layout.activity_track,menuId = 1,toolbarTitle = R.string.history_trail)
public class TrackActivity extends BaseActivity {

    private static final String TAG = "TrackActivity";
    private CalendarDay calendarDay;

    @BindView(R.id.mcv)
    MaterialCalendarView mcv;

    @Override
    protected void init() {
        mcv.setActivity(this);

        mcv.state().edit()
                .setMinimumDate(CalendarDay.from(2017,0,1))
                .setMaximumDate(Calendar.getInstance())
                .commit();

        mcv.setSelectedDate(new Date());

        mcv.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Log.e("adfadfeeeeee",date.getYear()+"===="+date.getMonth()+"==="+date.getDay());
                TrackActivity.this.calendarDay = calendarDay;
            }
        });

        mcv.setAddSelectedListener(new MaterialCalendarView.OnAddSelectedListener() {
            @Override
            public void addSelected(MaterialCalendarView view, CalendarDay calendarDay) {
                if (calendarDay != null) {
                    Log.e("adfadfeeeeee",calendarDay.getYear()+"==1=="+calendarDay.getMonth()+"==1=="+calendarDay.getDay());
                }
            }
        });
    }
}
