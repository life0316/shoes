package com.haoxi.shoes.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haoxi.shoes.R;
import com.haoxi.shoes.base.BaseLazyFragment;

public class ProfileFragment extends BaseLazyFragment {

    // 标志位，标志已经初始化完成。
    private boolean isPrepared;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.e("jiazai","预加载----ProfileFragment");
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        //XXX初始化view的各控件
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
    }
}
