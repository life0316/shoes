package com.haoxi.shoes.fragment;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haoxi.shoes.R;
import com.haoxi.shoes.act.TrackActivity;
import com.haoxi.shoes.base.BaseLazyFragment;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryFragment extends BaseLazyFragment {

    @BindView(R.id.map)
    MapView mMapView;


    private TencentMap tencentMap;
    private UiSettings uiSettings;
    private DemoLocationSource locationSource;
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Log.e("jiazai","预加载----HistoryFragment");
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        ButterKnife.bind(this,view);
        isPrepared = true;
        lazyLoad();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mMapView = view.findViewById(R.id.map);
        mMapView.setOnTop(false);
        tencentMap = mMapView.getMap();
        initMap();
    }

    private void initMap() {
        tencentMap.setMapType(TencentMap.MAP_TYPE_NORMAL);
        uiSettings = tencentMap.getUiSettings();

        uiSettings.setCompassEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        locationSource = new DemoLocationSource(getActivity());
        tencentMap.setLocationSource(locationSource);
        tencentMap.setMyLocationEnabled(true);
    }

    @OnClick(R.id.add_track)
    void addTrack(){
        Intent intent = new Intent(getActivity(), TrackActivity.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        mMapView.onStart();
        super.onStart();
    }

    @Override
    public void onResume() {
        mMapView.onResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        mMapView.onStop();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        mMapView.onDestroy();
        super.onDestroyView();
    }

    @Override
    protected void lazyLoad() {
        if(!isPrepared || !isVisible) {
            return;
        }
        //填充各控件的数据
        Log.e("jiazai","预加载----HistoryFragment-------1");
    }

    class DemoLocationSource implements LocationSource, TencentLocationListener {

        private Context mContext;
        private OnLocationChangedListener mChangedListener;
        private TencentLocationManager locationManager;
        private TencentLocationRequest locationRequest;

        public DemoLocationSource(Context context) {
            // TODO Auto-generated constructor stub
            mContext = context;
            locationManager = TencentLocationManager.getInstance(mContext);
            locationRequest = TencentLocationRequest.create();
            locationRequest.setInterval(1000 * 60 * 24 * 60);
        }

        @Override
        public void onLocationChanged(TencentLocation arg0, int arg1,
                                      String arg2) {
            // TODO Auto-generated method stub
            if (arg1 == TencentLocation.ERROR_OK && mChangedListener != null) {
                Log.e("maplocation", "location: " + arg0.getCity() + " " + arg0.getProvider());
                Location location = new Location(arg0.getProvider());
                location.setLatitude(arg0.getLatitude());
                location.setLongitude(arg0.getLongitude());
                location.setAccuracy(arg0.getAccuracy());
                mChangedListener.onLocationChanged(location);
            }
        }

        @Override
        public void onStatusUpdate(String arg0, int arg1, String arg2) {
            // TODO Auto-generated method stub
        }

        @Override
        public void activate(OnLocationChangedListener arg0) {
            // TODO Auto-generated method stub
            mChangedListener = arg0;
            int err = locationManager.requestLocationUpdates(locationRequest, this);
            switch (err) {
                case 1:
                    //setTitle("设备缺少使用腾讯定位服务需要的基本条件");
                    break;
                case 2:
                    //setTitle("manifest 中配置的 key 不正确");
                    break;
                case 3:
                    //setTitle("自动加载libtencentloc.so失败");
                    break;
                default:
                    break;
            }
        }

        @Override
        public void deactivate() {
            // TODO Auto-generated method stub
            locationManager.removeUpdates(this);
            mContext = null;
            locationManager = null;
            locationRequest = null;
            mChangedListener = null;
        }

        public void onPause() {
            locationManager.removeUpdates(this);
        }
        public void onResume() {
            //locationManager.requestLocationUpdates(locationRequest, this);
        }
    }
}
