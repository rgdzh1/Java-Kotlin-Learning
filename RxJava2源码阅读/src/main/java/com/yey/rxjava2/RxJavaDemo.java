package com.yey.rxjava2;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class RxJavaDemo {

    @Test
    public void test() {
        String initialReference = "哈哈哈";
        AtomicReference<String> atomicStringReference = new AtomicReference<String>(initialReference);
        String s = atomicStringReference.get();
        System.out.println(s);

    }


    @Test
    public void RxJava2案例() {
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
}
