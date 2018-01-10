package com.haoxi.shoes.act;

import android.support.v7.widget.AppCompatSeekBar;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.haoxi.shoes.R;
import com.haoxi.shoes.base.BaseActivity;
import com.haoxi.shoes.utils.ActivityFragmentInject;
import butterknife.BindView;

@ActivityFragmentInject(contentViewId = R.layout.activity_goal,menuId = 1,toolbarTitle = R.string.target)
public class GoalActivity extends BaseActivity implements SeekBar.OnSeekBarChangeListener {

    @BindView(R.id.sport_seekbar)
    AppCompatSeekBar sportSeekbar;
    @BindView(R.id.weight_seekbar)
    AppCompatSeekBar weightSeekbar;

    @BindView(R.id.goalStep)
    TextView stepTv;
    @BindView(R.id.goalWeight)
    TextView weightTv;
    @Override
    protected void init() {
        sportSeekbar.setProgress(10000);
        weightSeekbar.setProgress(60);
        sportSeekbar.setOnSeekBarChangeListener(this);
        weightSeekbar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        if (seekBar == sportSeekbar){
            stepTv.setText(i+"");
        }else if (seekBar == weightSeekbar){
            weightTv.setText(i+"");
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
