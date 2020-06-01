package com.yey.kotlin.proxy.dtdl;

import java.lang.reflect.Proxy;

public class Client {

    // 动态代理:代理类在程序运行时创建的代理方式
    public static void main(String[] args) {
        Man man = new Man();
        ManProxy manProxy = new ManProxy(man);
        /***
         * man.getClass().getClassLoader():目标类的类加载器
         * man.getClass().getInterfaces():目标类的接口,为代理类提供的接口
         * manProxy: 代理对象调用实现接口方法的时候最终调用到ManProxy.invoke().
         */
        // 获取目标类的代理对象
        Subject subject = (Subject) Proxy.newProxyInstance(man.getClass().getClassLoader(), man.getClass().getInterfaces(), manProxy);
        // 代理对象调用实现接口的方法shopping(),最终会调用到代理类中的invoke()
        subject.shopping();
        subject.run();
        // 打印代理对象
        System.out.println(subject.getClass().getName());
    }
}
