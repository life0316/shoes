package com.haoxi.shoes.act;

import android.support.v7.widget.AppCompatSeekBar;
import android.util.Log;
import android.widget.SeekBar;

import com.haoxi.shoes.R;
import com.haoxi.shoes.base.BaseActivity;
import com.haoxi.shoes.utils.ActivityFragmentInject;

import butterknife.BindView;

/**
 * Created by Administrator on 2017\12\25 0025.
 */

@ActivityFragmentInject(contentViewId = R.layout.activity_goal,menuId = 1,toolbarTitle = R.string.target)
public class GoalActivity extends BaseActivity {

    @BindView(R.id.sport_seekbar)
    AppCompatSeekBar sportSeekbar;

    @Override
    protected void init() {

        sportSeekbar.setProgress(3000);

        sportSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("fasewwwwww",String.valueOf(progress) + ", " + String.valueOf(fromUser));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
