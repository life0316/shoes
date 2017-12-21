package com.haoxi.shoes;

import android.os.Bundle;

import com.haoxi.shoes.base.MyBaseAdapter;
import com.haoxi.shoes.base.MyBaseFragment;
import com.haoxi.shoes.fragment.BindFragment;
import com.haoxi.shoes.fragment.HistoryFragment;
import com.haoxi.shoes.fragment.HomeFragment;
import com.haoxi.shoes.fragment.ProfileFragment;
import com.tencent.tencentmap.mapsdk.maps.SupportMapFragment;

public class MainFragment extends MyBaseFragment {

    @Override
    public void setupAdapter(MyBaseAdapter adapter) {
        adapter.addFragment(HomeFragment.class,"首页",getBundle("首页"));
        adapter.addFragment(HistoryFragment.class,"历史",getBundle("历史"));
        adapter.addFragment(BindFragment.class,"绑定",getBundle("绑定"));
        adapter.addFragment(ProfileFragment.class,"我的",getBundle("我的"));
    }

    public static MainFragment newInstance(String content){
        Bundle args = new Bundle();
        args.putString("ARGS",content);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
