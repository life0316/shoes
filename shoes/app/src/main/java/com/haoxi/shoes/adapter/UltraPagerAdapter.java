package com.haoxi.shoes.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.haoxi.shoes.R;

import java.util.List;

public class UltraPagerAdapter extends PagerAdapter {
    private boolean isMultiScr;
    private List<ImageView> imageLists = null;

    public UltraPagerAdapter(boolean isMultiScr,List<ImageView> imageLists) {
        this.isMultiScr = isMultiScr;
        this.imageLists = imageLists;
    }

    @Override
    public int getCount() {
        return imageLists == null?0:imageLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageLists.get(position));
        return imageLists.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
