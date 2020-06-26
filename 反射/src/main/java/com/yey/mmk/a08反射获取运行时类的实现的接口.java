package com.yey.mmk;

import org.junit.Test;

import java.lang.annotation.Annotation;

interface Eat {
}

class Persona08 implements Eat {

}

interface Run {
}

@MyAnnotaion
class Studenta08 extends Persona08 implements Run {

}

public class a08反射获取运行时类的实现的接口 {
    @Test
    public void 获取运行时类的接口() {
        Class<Studenta08> studenta08Class = Studenta08.class;
        Class<?>[] interfaces = studenta08Class.getInterfaces();
        for (Class c :
                interfaces) {
            System.out.println(c);
        }
    }

    @Test
    public void 获取运行时类父类的接口() {
        Class<Studenta08> studenta08Class = Studenta08.class;
        // 获取运行时类的父类
        Class<? super Studenta08> superclass = studenta08Class.getSuperclass();
        Class<?>[] interfaces = superclass.getInterfaces();
        for (Class c :
                interfaces) {
            System.out.println(c);
        }
    }

    @Test
    public void 运行时类的包() {
        Class<Studenta08> studenta08Class = Studenta08.class;
        Package aPackage = studenta08Class.getPackage();
        System.out.println(aPackage);
    }

    @Test
    public void 获取运行时类的注解() {
        Class<Studenta08> studenta08Class = Studenta08.class;
        Annotation[] annotations = studenta08Class.getAnnotations();
        for (Annotation a :
                annotations) {
            System.out.println(a);
        }
    }
}
