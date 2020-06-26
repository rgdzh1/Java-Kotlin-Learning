package com.yey.mmk;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class Persona07<T, E> {
    T t;
}

class Studenta07 extends Persona07<String, Integer> {

}

public class a07获取运行时类的父类及其泛型 {
    @Test
    public void 获取运行时类的父类() {
        Class<Studenta07> studenta07Class = Studenta07.class;
        // 获取运行时的父类
        Class<? super Studenta07> superclass = studenta07Class.getSuperclass();
        System.out.println(superclass);
    }

    @Test
    public void 获取运行时带泛型的父类() {
        Class<Studenta07> studenta07Class = Studenta07.class;
        Type genericSuperclass = studenta07Class.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    @Test
    public void 获取运行时类的父类的泛型() {
        Class<Studenta07> studenta07Class = Studenta07.class;
        Type genericSuperclass = studenta07Class.getGenericSuperclass();
        // 转为参数类型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        // 获取父类泛型参数数组
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type type : actualTypeArguments) {
//            System.out.println(type);
            // Type其实就是一个class
            Class classType = (Class) type;
            System.out.println(classType.getName());
        }

    }
}
