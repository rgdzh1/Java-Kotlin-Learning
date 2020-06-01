package com.yey.java.learning;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 泛型的类型必须是类,不能是基本数据类型,需要用到基本数据类型的地方可以用包装类代替
 * 假如集合或者map实例化时候没有指明泛型,则默认为Object类型.
 */
public class a01初识泛型 {
    @Test
    public void 未使用泛型引发的问题() {
        ArrayList scores = new ArrayList();
        // 用来存放学生的成绩
        scores.add(60);
        scores.add(64);
        scores.add(80);
        scores.add(90);
        // 问题一: 类型不安全,因为没有限制可能往里面存入了字符串,运行程序时就会暴露这个错误.
        // 这样看来,List还不如数组,数组对存入的对象都会做严格的要求.
//        scores.add("Tom");
        for (Object score : scores) {
            // 强转时候,可能会出现ClassCastException
            int stuScore = (int) score;
            System.out.println(stuScore);
        }
    }

    @Test
    public void 使用泛型如何解决问题() {
        // 这里泛型不允许为基本数据类型,因为基本数据类型不属于Object范畴.
        // ArrayList<int> scores = new ArrayList();
        ArrayList<Integer> scores = new ArrayList();
        scores.add(60);
        scores.add(69);
        scores.add(80);
        scores.add(90);
        // 编译时就会进行类型检查,保证了数据安全.
//        scores.add("Tom")

        // 增强for循环
//        for (Integer score : scores) {
//            int stuScore = score;
//            System.out.println(stuScore);
//        }
        // 迭代器
        Iterator<Integer> iterator = scores.iterator();
        while (iterator.hasNext()){
            Integer score = iterator.next();
            System.out.println(score);
        }
    }
}
