package com.yey.java.learning;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a07泛型通配符的使用 {
    @Test
    public void test() {
        // 类A是类B的父类,G<A>和G<B>是没有关系的,不过二者共同的父类为G<?>
        ArrayList<Object> list1 = null;
        ArrayList<String> list2 = null;
        ArrayList<?> list = null;
        list = list1;
        list = list2;
        print(list1);
        print(list2);
    }
    // List<?> list是ArrayList<Object>,ArrayList<String>的父类
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
