package com.yey.studio.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                        System.out.println("被观察者发射数据线程: " + Thread.currentThread().getId());
                        emitter.onNext(100);

                    }
                })
                        .subscribeOn(Schedulers.io()) // 被观察者发射消息从io线程
                        .observeOn(AndroidSchedulers.mainThread()) // 观察者接收消息后在AndroidSchedulers.mainThread()新线程中处理
                        .subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                System.out.println("onSubscribe");
                            }

                            @Override
                            public void onNext(Integer integer) {
                                System.out.println("onNext: " + integer);
                                System.out.println("观察者接收数据线程: " + Thread.currentThread().getId());
                            }

                            @Override
                            public void onError(Throwable e) {
                                System.out.println("onError");
                            }

                            @Override
                            public void onComplete() {
                                System.out.println("onComplete");
                            }
                        });
            }
        });
    }
}
