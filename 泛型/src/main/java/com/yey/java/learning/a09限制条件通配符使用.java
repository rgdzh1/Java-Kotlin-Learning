package com.yey.java.learning;

import org.junit.Test;

import java.util.ArrayList;

class Person {
}

class Student extends Person {
}

public class a09限制条件通配符使用 {
    @Test
    public void test() {
        // 有上限的通配符,像(-∞~Person]
        ArrayList<? extends Person> list1 = null;
        // 有下限的通配符,像[Person~+∞)
        ArrayList<? super Person> list2 = null;

        // Person < Object
        ArrayList<Object> list3 = null;
        // Person = Person
        ArrayList<Person> list4 = null;
        // Student<Person
        ArrayList<Student> list5 = null;

        // list1的泛型上限是Person,没有下限,
        // list3的泛型是Object,超过Person类型肯定不能被list1接收的
        list1 = list3;// 编译异常
        // list3的泛型是Person,等于Person类型,肯定能被list1接收.
        list1 = list4;// 编译通过
        // list5的泛型是Student,小于Person类型,肯定能被list1接收.
        list1 = list5;// 编译通过

        // list2的泛型下限是Person,没有上限.
        // list3的泛型是Object,超过Person类型肯定能被list2接收
        list2 = list3;// 编译通过
        // list4的泛型是Person,等于Person类型肯定能被list2接收
        list2 = list4;// 编译通过
        // list5的泛型是Student,小于Person类型,肯定不能被list2接收.
        list2 = list5;// 编译异常

        // list1的泛型上限是Person,没有下限,(-∞~Person]
        // list2的泛型下限是Person,没有上限,[Person~+∞)
        // 读操作
        Person person = list1.get(0);// list1中所有的元素都是Person的子类
        Object object = list1.get(0);// list1中所有的元素都是Object的子类
        Object object1 = list2.get(0);// list2中所有的元素都是Object的子类

        // 写操作
        // list1是没有下限的,根本不知道list1的泛型是Person或者Student抑或是Person其他子类,
        // 比如向list1中添加Person类元素,而list1实际泛型是Student,父类是不能强制转为子类的,肯定提示编译异常.
        // 再或者向list1中添加Student元素,而list1实际泛型是Student类子类,也是会编译异常.
        // 所以永远都不知道list1的真实泛型类型,这也就不可能向list1中写入元素了.
        list1.add(new Person());// 编译异常
        list1.add(new Student());// 编译异常

        // list2是有下限的,
        // 比如向list2中添加它的泛型下限类型的子类也就是Person类或者Person类的子类,是可以的.因为子类可以用父类接收(多态)
        // 但是向list2中添加大于它泛型下限的类是不行了,
        // 与list1中说的原因类似,假如向list2中添加一个(class Person1 extends Person{})类,但是list2中真实的泛型类型是(class Person2 extends Person{})类,这样肯定是提示编译异常.
        list2.add(new Person());// 编译通过
        list2.add(new Student());// 编译通过
        list2.add(new Object());// 编译异常
    }
}
