package com.yey.mmk;

import org.junit.Test;

import java.lang.reflect.Constructor;

class Persona06 {
    public Persona06() {
    }

    String eat;

    public Persona06(String eat) {
        this.eat = eat;
    }
}

class Studenta06 extends Persona06 {
    public Studenta06() {
    }

    String name;

    public Studenta06(String name) {
        this.name = name;
    }

    private Studenta06(String eat, String name) {
        super(eat);
        this.name = name;
    }
}

public class a06反射获取类的构造器 {
    @Test
    public void 获取当前运行时类中声明Public构造器() {
        Class<Studenta06> studenta06Class = Studenta06.class;
        // 获取当前运行时类中声明为Public的构造器
        Constructor<?>[] constructors = studenta06Class.getConstructors();
        for (Constructor c :
                constructors) {
            System.out.println(c);
        }
    }

    @Test
    public void 获取当前运行时类所有构造器() {
        Class<Studenta06> studenta06Class = Studenta06.class;
        // 获取当前运行时类中声明的所有构造器
        Constructor<?>[] constructors = studenta06Class.getDeclaredConstructors();
        for (Constructor c :
                constructors) {
            System.out.println(c);
        }
    }
}
