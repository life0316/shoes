package com.haoxi.shoes.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haoxi.shoes.R;
import com.haoxi.shoes.act.AffectActivity;
import com.haoxi.shoes.act.GoalActivity;
import com.haoxi.shoes.act.PersonDetailActivity;
import com.haoxi.shoes.act.PreventActivity;
import com.haoxi.shoes.act.SettingActivity;
import com.haoxi.shoes.act.UpgradeActivity;
import com.haoxi.shoes.base.BaseLazyFragment;
import com.haoxi.shoes.model.mine.PersonActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragment extends BaseLazyFragment {

    // 标志位，标志已经初始化完成。
    private boolean isPrepared;

    @BindView(R.id.profile_civ)
    ImageView mHeaderIv;
    @BindView(R.id.profile_name)
    TextView mNameTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.e("jiazai","预加载----ProfileFragment");
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this,view);
        //XXX初始化view的各控件
        isPrepared = true;
        lazyLoad();
        return view;
    }
    @OnClick(R.id.profile_goal)
    public void setProfileGoal(){
        Intent intent = new Intent(getActivity(), GoalActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.setting)
    public void setting(){
        Intent intent = new Intent(getActivity(), SettingActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.profile_civ)
    public void headCiv(){
        Intent intent = new Intent(getActivity(), PersonActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.profile_affection)
    public void affection(){
        Intent intent = new Intent(getActivity(), AffectActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.profile_upgrade)
    public void upgrade(){
        Intent intent = new Intent(getActivity(), UpgradeActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.profile_lose)
    public void prevent(){
        Intent intent = new Intent(getActivity(), PreventActivity.class);
        startActivity(intent);
    }

    @Override
    protected void lazyLoad() {
        if(!isPrepared || !isVisible) {
            return;
        }
        //填充各控件的数据
        Log.e("jiazai","预加载----ProfileFragment-------1");
        mHeaderIv.setImageResource(R.mipmap.run1);
    }
}
