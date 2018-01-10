package com.haoxi.shoes.fragment;

import android.graphics.Bitmap;
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

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.haoxi.shoes.R;
import com.haoxi.shoes.adapter.UltraPagerAdapter;
import com.haoxi.shoes.base.BaseLazyFragment;
import com.haoxi.shoes.bean.HistoryBean;
import com.haoxi.shoes.retrofit.RetrofitManager;
import com.haoxi.shoes.retrofit.TxAnswer;
import com.haoxi.shoes.retrofit.TxUtils;
import com.haoxi.shoes.widget.CompletedView;
import com.haoxi.shoes.widget.TenHistroyView;
import com.tmall.ultraviewpager.UltraViewPager;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class HomeFragment extends BaseLazyFragment {
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;
    private List<HistoryBean> eachList = new ArrayList<>();

    @BindView(R.id.tenview)
    TenHistroyView histroyView;

    @BindView(R.id.tasks_view)
    CompletedView roundProgress;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.e("jiazai","预加载----HomeFragment");
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        isPrepared = true;
        lazyLoad();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        roundProgress.setmTotalProgress(10000);

        initUltra(view);

    }

    @OnClick(R.id.add_goal)
    void addGoal(){

        eachList.add(new HistoryBean(300,"1日"));
        eachList.add(new HistoryBean(500,"2日"));
        eachList.add(new HistoryBean(600,"3日"));
        eachList.add(new HistoryBean(200,"4日"));
        eachList.add(new HistoryBean(900,"5日"));
        eachList.add(new HistoryBean(200,"6日"));
        eachList.add(new HistoryBean(100,"7日"));
        eachList.add(new HistoryBean(1000,"8日"));
        eachList.add(new HistoryBean(400,"9日"));
        eachList.add(new HistoryBean(600,"10日"));

        histroyView.setEachList(eachList);

        new Thread(new ProgressRunable()).start();

        getTxAnswer("今天在学校被打了");

    }
    private int mTotalProgress = 5100;
    private int mCurrentProgress = 0;

    class ProgressRunable implements Runnable {
        @Override
        public void run() {
            while (mCurrentProgress < mTotalProgress) {
                mCurrentProgress += 100;
                roundProgress.setProgress(mCurrentProgress);
                try {
                    Thread.sleep(30);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void lazyLoad() {
        if(!isPrepared || !isVisible) {
            return;
        }
        //填充各控件的数据
        Log.e("jiazai","预加载----HomeFragment-------1");
        Log.e("jiazai","预加载----HomeFragment--------------"+AppUtils.getAppPath());

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
            Bitmap bitmap = ImageUtils.getBitmap(imageLists.get(i));
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
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
    protected RetrofitManager.IOurNewService ourNewService;
    private void getTxAnswer(String text){

        String APP_ID = "1106552241";
        String APP_KEY = "BK9O2o1lEudlc2ej";
        String time_stamp =  System.currentTimeMillis()/1000+"";
        String nonce_str = TxUtils.getRandomString(10);
        String session = "10000";
        String question = text;

        try {
            question = java.net.URLEncoder.encode(text,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String sign = TxUtils.convertString((TxUtils.MD5("app_id=" + APP_ID
                +"&nonce_str="+nonce_str
                +"&question="+ question
                + "&session=" + session
                +"&time_stamp="+ time_stamp
                +  "&app_key=" + APP_KEY)));

        Map<String,String> map = new HashMap<>();
        map.put("app_id",APP_ID);
        map.put("nonce_str",nonce_str);
        map.put("question",question);
        map.put("session",session);
        map.put("time_stamp",time_stamp);
        map.put("sign",sign);

        Log.e("txurl-----",map.toString());
        ourNewService = RetrofitManager.builder().getOurNewService();
        ourNewService.getTxAnswer(APP_ID,sign,session,question,nonce_str,time_stamp)
                .subscribeOn(Schedulers.newThread())
                .filter(new Predicate<TxAnswer>() {
                    @Override
                    public boolean test(TxAnswer txAnswer) throws Exception {
                        return txAnswer.getRet() == 0 && txAnswer.getData() != null;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TxAnswer>() {
                    @Override
                    public void accept(TxAnswer txAnswer) throws Exception {
                        if (txAnswer.getData().getAnswer() != null){
                            Log.e("txurl-----",txAnswer.getMsg()+"---------"+txAnswer.getData().getAnswer());
                        }
                    }
                });
    }
}
