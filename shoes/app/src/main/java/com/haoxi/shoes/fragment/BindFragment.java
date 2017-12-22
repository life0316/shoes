package com.haoxi.shoes.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.haoxi.shoes.R;
import com.haoxi.shoes.act.EditShoesActivity;
import com.haoxi.shoes.base.BaseLazyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BindFragment extends BaseLazyFragment implements View.OnClickListener {

    @BindView(R.id.add_device)
    LinearLayout addDeviceLl;

    @BindView(R.id.shoes_show)
    LinearLayout shoesShowLl;

    @BindView(R.id.add_device_btn)
    Button addDeviceBtn;

    @BindView(R.id.shoes_edit_btn)
    Button shoesEditBtn;

    @BindView(R.id.shoes_delect_btn)
    Button shoesDelectBtn;

    private boolean isShow = true;
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Log.e("jiazai","预加载----BindFragment");
        View view = inflater.inflate(R.layout.fragment_bind, container, false);
        ButterKnife.bind(this,view);
        //XXX初始化view的各控件
        isPrepared = true;
        lazyLoad();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
                Intent intent = new Intent(getActivity(), EditShoesActivity.class);
                startActivity(intent);
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
