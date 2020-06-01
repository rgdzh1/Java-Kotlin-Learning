package com.yey.java.learning;

import com.sun.xml.internal.fastinfoset.algorithm.IntEncodingAlgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a08数据使用泛型通配符之后的读与写 {
    @Test
    public void test() {
        ArrayList<?> list = null;
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        // 将list1赋值给list
        list = list1;
        // 向list中添加数据,是不允许的.
        // 将<?>比如为+∞~-∞,
        // ArrayList<?>有可能是ArrayList<Integer>或者ArrayList<String>或者ArrayList<Boolean>,
        // 根本无法确定list1到底是什么具体类型,所以不能向其中添加数据
//        list.add(10)
//        list.add("小明")
        printList(list);
        // 其实也有例外,list中可以添加null数据
        // 因为任何对象都能以null为值.
        list.add(null);
    }

    /**
     * List<?> list: 不会影响到读数据
     *
     * @param list
     */
    public void printList(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
