package com.yey.generic;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public class RetrofitDemo {
    interface MyService {
        @GET("/App/Index/main")
        Observable<Object> getUser(@Query("user") String user);
    }

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://test.ph.jikecash.com")
                .client(new OkHttpClient()
                        .newBuilder()
                        .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                            @Override
                            public void log(String message) {
                                System.out.println("Retrofiit源码阅读: " + message);
                            }
                        })
                                .setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MyService service = retrofit.create(MyService.class);
        Observable<Object> userApi = service.getUser("XXX");
        userApi.subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
