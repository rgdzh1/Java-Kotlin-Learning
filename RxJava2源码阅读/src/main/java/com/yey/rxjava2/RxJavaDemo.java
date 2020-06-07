package com.yey.rxjava2;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import sun.rmi.runtime.Log;


public class RxJavaDemo {

    @Test
    public void AtomicReferenceDemo() {
        String initialReference = "哈哈哈";
        AtomicReference<String> atomicStringReference = new AtomicReference<String>(initialReference);
        String s = atomicStringReference.get();
        System.out.println(s);

    }

    @Test
    public void RxJava2订阅流程() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("Hello World");
                emitter.onComplete();
            }
        })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                        // 取消订阅后,ObservableEmitter发出的消息,观察者Observer将不会再收到.
                        d.dispose();
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext: " + s);
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

    @Test
    public void RxJava2线程切换() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.println("被观察者发射数据线程: " + Thread.currentThread().getId());
                emitter.onNext(100);

            }
        })
                .subscribeOn(Schedulers.io()) // 被观察者发射消息从io线程
                .observeOn(Schedulers.newThread()) // 观察者接收消息后在Schedulers.newThread()新线程中处理
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
    @Test
    public void just操作符(){
        Observable.just(1, 2, 3,4,5,6,7,8,9,10)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
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





    @Test
    public void map操作符() {
        Observable.just(1, 2, 3)
                // 可以将被观察者发送的数据类型转变成其他的类型
                .map(new Function< Integer, String >() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "I'm " + integer;
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                        // 取消订阅后,ObservableEmitter发出的消息,观察者Observer将不会再收到.
                        d.dispose();
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext: " + s);
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
}
