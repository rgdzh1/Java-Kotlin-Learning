package com.yey.mmk;

class PersonX {
}

public class a02获取Class实例4种方法 {

    public static void main(String[] args) throws ClassNotFoundException {
        // 方式一:调用运行时类的属性
        Class<PersonX> personClass = PersonX.class;
        System.out.println(personClass);
        // 通过运行时类的对象,调用getClass()
        PersonX person = new PersonX();
        Class<? extends PersonX> aClass = person.getClass();
        System.out.println(aClass);
        // 调用静态方法 forName()
        Class<?> aClass1 = Class.forName("com.yey.mmk.PersonX");
        System.out.println(aClass1);
        // 使用类的加载器 ClassLoader
        ClassLoader classLoader = PersonX.class.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("com.yey.mmk.PersonX");
        System.out.println(aClass2);
    }
}
