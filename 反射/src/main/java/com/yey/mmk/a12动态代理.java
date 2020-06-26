package com.yey.mmk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
    String getBelief();

    void eat(String eat);
}

// 被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String eat) {
        System.out.println("吃" + eat);
    }
}

/**
 * 动态代理
 * 问题一:如何根据加载到内存中的被代理类动态的创建一个代理类及其对象
 * 问题二:当通过代理类的对象调用方法时,如何动态的去调用被代理类中的同名方法
 */
class ProxyFactoty {
    // 调用此方法: 返回一个代理类的对象
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        // obj: 被代理类对象
        // 返回值是一个代理类对象
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                myInvocationHandler
        );
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object object;// 被代理对象

    public void bind(Object o) {
        object = o;
    }

    // 当我们通过代理类对象调用方法a时,就会自动调用如下的方法:invoke()
    // 此时,被代理类的a()方法就放在invoke()中执行.
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        // Object o 代理类对象
        // Method method 次方法为代理类调用的方法也作为被代理类调用的方法
        // Object[] objects 参数
        Object returnValue = method.invoke(object, objects);
        // 方法执行的返回值
        return returnValue;
    }
}


public class a12动态代理 {
    public static void main(String[] args) {
        // 代理类对象
        Human proxyInstance = (Human) ProxyFactoty.getProxyInstance(new SuperMan());
        // 通过代理类对象调用方法时,会自动调用被代理类中同名的方法
        proxyInstance.eat("橘子");
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
    }
}
