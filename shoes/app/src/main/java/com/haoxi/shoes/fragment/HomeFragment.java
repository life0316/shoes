package com.haoxi.shoes.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.haoxi.shoes.R;
import com.haoxi.shoes.adapter.UltraPagerAdapter;
import com.haoxi.shoes.base.BaseLazyFragment;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseLazyFragment {
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.e("jiazai","预加载----HomeFragment");
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        isPrepared = true;
        lazyLoad();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUltra(view);
    }

    @Override
    protected void lazyLoad() {
        if(!isPrepared || !isVisible) {
            return;
        }
        //填充各控件的数据
        Log.e("jiazai","预加载----HomeFragment-------1");
    }

    private void initUltra(View view) {
        UltraViewPager ultraViewPager = view.findViewById(R.id.home_ultra);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        List<Integer> imageLists = new ArrayList();
        imageLists.add(R.mipmap.run1);
        imageLists.add(R.mipmap.run2);
        imageLists.add(R.mipmap.run3);
        imageLists.add(R.mipmap.run4);
        imageLists.add(R.mipmap.run5);

        //显示的图片
       List<ImageView> images = new ArrayList();
        for(int i = 0; i < imageLists.size(); i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageLists.get(i));
            images.add(imageView);
        }

        PagerAdapter adapter = new UltraPagerAdapter(false,images);
        ultraViewPager.setAdapter(adapter);

        ultraViewPager.initIndicator();
        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(Color.GREEN)
                .setNormalColor(Color.WHITE)
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));
        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);

        ultraViewPager.getIndicator().build();

        ultraViewPager.setInfiniteLoop(true);

        ultraViewPager.setAutoScroll(3000);
    }
}
