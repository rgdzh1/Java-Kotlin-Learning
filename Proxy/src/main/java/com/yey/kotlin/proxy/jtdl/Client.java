package com.yey.kotlin.proxy.jtdl;

// 客户端
public class Client {
    public static void main(String[] args) {
        ProxyObject proxyObject = new ProxyObject(new RealObject());
        // 客户端调用代理对象
        // 代理对象会将调用委派给目标对象
        proxyObject.operation();
    }
}
