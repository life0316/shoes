package com.haoxi.shoes.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haoxi.shoes.R;
import com.haoxi.shoes.act.AboutActivity;
import com.haoxi.shoes.act.GoalActivity;
import com.haoxi.shoes.base.BaseLazyFragment;
import com.haoxi.shoes.model.mine.PersonActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ProfileFragment2  extends BaseLazyFragment {

    // 标志位，标志已经初始化完成。
    private boolean isPrepared;

    @BindView(R.id.profile_civ)
    ImageView mHeaderIv;
    @BindView(R.id.profile_name)
    TextView mNameTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile2, container, false);
        ButterKnife.bind(this,view);
        isPrepared = true;
        lazyLoad();
        return view;
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

    @OnClick(R.id.profile_civ)
    public void headCiv(){
        Intent intent = new Intent(getActivity(), PersonActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.profile_goal)
    public void setProfileGoal(){
        Intent intent = new Intent(getActivity(), GoalActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.about_xgn)
    public void aboutXgn(){
        Intent intent = new Intent(getActivity(), AboutActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.profile_shop)
    void xgnShop(){
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse("https://xgnxl.m.tmall.com/?spm=a1z10.3-b-s.1997427721.d4918089.42cfcb65YmFdvn");
        intent.setData(content_url);
        startActivity(intent);
    }

}
