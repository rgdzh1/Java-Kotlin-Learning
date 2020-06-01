package com.yey.kotlin.proxy.jtdl;

// 目标类,实现了代理接口
public class RealObject extends Subject{
    @Override
    protected void operation() {
        System.out.println("do operation ...");
    }
}
