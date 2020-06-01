package com.yey.kotlin.proxy.dtdl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 代理类
public class ManProxy implements InvocationHandler {
    //  目标对象
    private Object realObject;
    public ManProxy(Subject realObject) {
        this.realObject = realObject;
    }
    /**
     *
     * @param proxy 目标对象的代理
     * @param method 对应目标对象中的某个方法,在客户端代理对象调用哪个方法,这里的method就对应那个方法.
     * @param args 对应目标对象中某个方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 打印代理对象
        System.out.println(proxy.getClass().getName());
        System.out.println("before...");
        // 代理对象将客户端调用委派给目标对象
        method.invoke(realObject, args);
        System.out.println("after...");
        return null;
    }
}
