package com.haoxi.shoes.fragment;

import android.os.Bundle;

import com.haoxi.shoes.R;
import com.haoxi.shoes.base.MyBaseAdapter;
import com.haoxi.shoes.base.MyBaseFragment;

public class MainFragment extends MyBaseFragment {

    @Override
    public void setupAdapter(MyBaseAdapter adapter) {
        adapter.addFragment(HomeFragment.class,getString(R.string.home_name),getBundle(getString(R.string.home_name)));
        adapter.addFragment(HistoryFragment.class,getString(R.string.history_name),getBundle(getString(R.string.history_name)));
        adapter.addFragment(BindFragment.class,getString(R.string.bind_name),getBundle(getString(R.string.bind_name)));
        adapter.addFragment(ProfileFragment2.class,getString(R.string.profile_name),getBundle(getString(R.string.profile_name)));
    }

    public static MainFragment newInstance(String content){
        Bundle args = new Bundle();
        args.putString("ARGS",content);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
