package com.yey.mmk;

import org.junit.Test;

import java.lang.reflect.Constructor;


class Persona10 {
    private String name;
    private int age;

    public Persona10(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persona10{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class a10调用运行时类指定的构造器 {
    @Test
    public void 调用运行时类构造器() throws Exception {
        Class<Persona10> persona10Class = Persona10.class;
        /**
         * 获取指定的构造器
         * getDeclaredConstructor(): 参数:指定构造器中参数列表
         */
        Constructor<Persona10> declaredConstructor = persona10Class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        Persona10 persona10 = declaredConstructor.newInstance("张三", 23);
        System.out.println(persona10);
    }
}
