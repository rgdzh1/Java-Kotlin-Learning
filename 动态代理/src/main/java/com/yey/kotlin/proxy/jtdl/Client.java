package com.yey.kotlin.proxy.jtdl;

import java.util.ArrayList;

// 客户端
public class Client {
    public static void main(String[] args) {
//        ProxyObject proxyObject = new ProxyObject(new RealObject());
//        // 客户端调用代理对象
//        // 代理对象会将调用委派给目标对象
//        proxyObject.operation();

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        int i = strings.indexOf(null)+1;
        System.out.println(i);
    }
}
