package com.yey.java.learning;

import com.sun.org.apache.xpath.internal.objects.XNull;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class a06泛型在继承方面的体现 {
    @Test
    public void test1() {
        // 假如A类是B类的父类,G<A>和G<B>是不存在子父类关系的.
        ArrayList<String> list1 = null;
        ArrayList<Object> list2 = null;
        // list1与list2不具备子父类关系,虽然他们泛型参数是子父类关系.他们属于两种不同类型的对象.
//        list2 = list1; 编译不通过
//        list1 = list2; 编译不通过
        show1(list1);
//        show1(list2); 虽然list1与list2数据类型都是ArrayList,但是他们的泛型参数不同,导致list1与list2其实是两个不同的对象.
//        show2(list1);
        show2(list2);
    }

    public void show1(ArrayList<String> arrayList) {

    }

    public void show2(ArrayList<Object> arrayList) {

    }

    @Test
    public void test2() {
        List<String> list1 = null;
        ArrayList<String> list2 = null;
        // list2是list1的子类,他们的泛型参数是相同的,但是list1与list2的数据类型是子父类关系.
        list1 = list2;
    }
}
