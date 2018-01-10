package com.haoxi.shoes.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitManager {

    private static final String BASE_URL = "https://api.ai.qq.com/fcgi-bin/nlp/";
    private static IOurNewService ourNewService;
    private static Retrofit ourRetrofit;
    private RetrofitManager() {

    }

    public static void initRetrofit(){
        Gson gson = new GsonBuilder()
                .setLenient().create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        ourRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ourNewService = ourRetrofit.create(IOurNewService.class);
    }

    public static RetrofitManager builder(){
        return new RetrofitManager();
    }

    public Retrofit getOurRetrofit(){return ourRetrofit;}

    public IOurNewService getOurNewService() {
        return ourNewService;
    }

    public interface IOurNewService{
//        @GET("nlp_textchat")
//        Observable<TxAnswer> getTxAnswer(@QueryMap Map<String, String> map);

        @GET("nlp_textchat")
        Observable<TxAnswer> getTxAnswer(@Query("app_id") String app_id,
                                         @Query("sign") String sign,
                                         @Query("session") String session,
                                         @Query(value = "question", encoded = true) String question,
                                         @Query("nonce_str") String nonce_str,
                                         @Query("time_stamp") String time_stamp);
    }
}
