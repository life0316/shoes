package com.haoxi.shoes.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.haoxi.shoes.R;
import com.haoxi.shoes.base.BaseLazyFragment;

public class BindFragment extends BaseLazyFragment implements View.OnClickListener {

    private LinearLayout addDeviceLl;
    private LinearLayout shoesShowLl;
    private Button addDeviceBtn;
    private Button shoesEditBtn;
    private Button shoesDelectBtn;

    private boolean isShow = true;
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Log.e("jiazai","预加载----BindFragment");
        View view = inflater.inflate(R.layout.fragment_bind, container, false);
        //XXX初始化view的各控件
        isPrepared = true;
        lazyLoad();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addDeviceLl = view.findViewById(R.id.add_device);
        shoesShowLl = view.findViewById(R.id.shoes_show);
        shoesEditBtn = view.findViewById(R.id.shoes_edit_btn);
        addDeviceBtn = view.findViewById(R.id.add_device_btn);
        shoesDelectBtn = view.findViewById(R.id.shoes_delect_btn);
        addDeviceBtn.setOnClickListener(this);
        shoesEditBtn.setOnClickListener(this);
        shoesDelectBtn.setOnClickListener(this);

        if (isShow){
            addDeviceLl.setVisibility(View.VISIBLE);
            shoesShowLl.setVisibility(View.GONE);
        }else {
            addDeviceLl.setVisibility(View.GONE);
            shoesShowLl.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_device_btn:
                addDeviceLl.setVisibility(View.GONE);
                shoesShowLl.setVisibility(View.VISIBLE);
                break;
            case R.id.shoes_edit_btn:
                break;
            case R.id.shoes_delect_btn:
                break;
        }
    }

    @Override
    protected void lazyLoad() {
        if(!isPrepared || !isVisible) {
            return;
        }
        //填充各控件的数据
        Log.e("jiazai","预加载----BindFragment-------1");
    }
}
