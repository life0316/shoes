package com.haoxi.shoes.base;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.haoxi.shoes.R;
import com.haoxi.shoes.utils.DepthPageTransformer;
import com.haoxi.shoes.widget.CustomViewPager;

public abstract class MyBaseFragment extends Fragment {

    protected MyBaseAdapter adapter;
    TabLayout mTablayout;
    CustomViewPager mViewPager;

    protected Bundle getBundle(String arg) {
        Bundle bundle = new Bundle();
        bundle.putString("key", arg);
        return bundle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mybase, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTablayout = view.findViewById(R.id.fragment_base_tabs);
        mViewPager = view.findViewById(R.id.fragment_base_cvp);

        isPaging(true);
        mViewPager.setOffscreenPageLimit(3);
        //mViewPager.setPageTransformer(true, new DepthPageTransformer());
        adapter = new MyBaseAdapter(getChildFragmentManager(), mViewPager, mTablayout, getActivity());
        mTablayout.setupWithViewPager(mViewPager);
        adapter.clearFragment();
        setupAdapter(adapter);
    }

    protected void isPaging(boolean ispag) {
        mViewPager.setPagingEnabled(ispag);
    }
    public abstract void setupAdapter(MyBaseAdapter adapter);
}
