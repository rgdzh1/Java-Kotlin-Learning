package com.yey.kotlin.proxy.dtdl;
// 目标类
public class Man implements Subject {
    @Override
    public void shopping() {
        System.out.println("shopping...");
    }

    @Override
    public void run() {
        System.out.println("run...");
    }
}
