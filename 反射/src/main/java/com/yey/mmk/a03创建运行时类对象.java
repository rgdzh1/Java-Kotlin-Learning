package com.yey.mmk;

import org.junit.Test;

class Persona03 {
    String name = "张三";
}

public class a03创建运行时类对象 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Persona03> persona03Class = Persona03.class;
        // 要执行newInstance()那么运行时类必须提供一个空参构造器,这个构造器的访问权限必须够
        Persona03 persona03 = persona03Class.newInstance();
        System.out.println(persona03.name);
        /**
         * JavaBean中要求提供一个public空参构造器,便于通过反射创建运行时类对象
         * 便于子类继承此运行时类时,默认调用super()时,保证父类有此构造器
         */
    }
     @Test
    public void 反射动态性() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 反射的动态性,一个方法可以创建不同的对象.
        getInstance("com.yey.mmk.PersonX");
         getInstance("com.yey.mmk.Persona03");
     }

    private void getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName(classPath);
        Object instance = aClass.newInstance();
        System.out.println(instance);
    }
}
