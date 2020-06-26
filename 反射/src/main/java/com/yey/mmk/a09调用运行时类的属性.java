package com.yey.mmk;

import org.junit.Test;

import java.lang.reflect.Field;

class Persona09 {
    public String age;
    private String weight;
    String sing;
}

class Studenta09 extends Persona09 {

    private String name;
    public int height;
    String eat;
}

public class a09调用运行时类的属性 {
    @Test
    public void 调用运行时类的public属性() throws Exception, InstantiationException {
        Class<Studenta09> studenta09Class = Studenta09.class;
        // 创建运行时类对象
        Studenta09 studenta09 = studenta09Class.newInstance();
        // 获取指定的属性
        Field heightField = studenta09Class.getField("height");
        /**
         * 为属性设置值
         * set() 参数1 指定对象, 参数2 该属性值设置为多少
         */
        heightField.set(studenta09, 100);
        /**
         * 获取当前属性值
         * get() 参数1: 当前对象
         */
        int height = (int) heightField.get(studenta09);
        System.out.println(height);
    }

    @Test
    public void 调用运行时类的private属性() throws Exception {
        Class<Studenta09> studenta09Class = Studenta09.class;
        Studenta09 studenta09 = studenta09Class.newInstance();
        // 获取私有属性
        Field nameField = studenta09Class.getDeclaredField("name");
        // 保证当前属性是可以访问的,强制访问
        nameField.setAccessible(true);
        nameField.set(studenta09, "张三");
        System.out.println(nameField.get(studenta09));
    }
}
