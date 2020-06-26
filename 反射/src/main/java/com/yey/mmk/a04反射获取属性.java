package com.yey.mmk;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Persona04 {
    public String age;
    private String weight;
    String sing;
}

class Studenta04 extends Persona04 {

    public String name;
    private String height;
    String eat;
}

public class a04反射获取属性 {
    @Test
    public void 反射获取所有属性getFields() {
        Class<Studenta04> studenta04Class = Studenta04.class;
        // getFields(): 该方法能够获取当前运行时类及其父类种声明的所有的public访问权限的属性
        Field[] fields = studenta04Class.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
    }

    @Test
    public void 反射获取私有属性getDeclaredFields() {
        Class<Studenta04> studenta04Class = Studenta04.class;
        // getDeclaredFields()获取当前运行时类中声明的所有属性,不论是publice,private,默认权限等等
        // 都能获取到.
        // 但是没有办法获取到父类的属性,父类的属性这个方法一个都获取不到.
        Field[] declaredFields = studenta04Class.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
    }

    @Test
    public void 反射获取属性的信息() {
        Class<Studenta04> studenta04Class = Studenta04.class;
        Field[] declaredFields = studenta04Class.getDeclaredFields();
        for (Field f : declaredFields) {
            // 属性权限修饰符
            int modifiers = f.getModifiers();
            String modifier = Modifier.toString(modifiers);
            // 数据类型
            Class<?> type = f.getType();
            // 变量名字
            String name = f.getName();
            System.out.println("权限修饰符:" + modifier + "  数据类型:" + type + "  变量名字:" + name);
        }
    }
}
