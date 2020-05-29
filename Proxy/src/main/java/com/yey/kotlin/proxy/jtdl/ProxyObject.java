package com.yey.kotlin.proxy.jtdl;

// 代理类,实现了代理接口
public class ProxyObject extends Subject {
    // 目标类型
    private RealObject realObject;

    public ProxyObject(RealObject realObject) {
        this.realObject = realObject;
    }

    // 代理对象将客户端的调用委派给了目标对象,
    // 在调用目标对象之前与之后都可以执行某些特定操作.
    @Override
    protected void operation() {
        System.out.println("do something before real operation ...");
        if (realObject == null) {
            realObject = new RealObject();
        }
        realObject.operation();
        System.out.println("do something after real operation ...");
    }
}
