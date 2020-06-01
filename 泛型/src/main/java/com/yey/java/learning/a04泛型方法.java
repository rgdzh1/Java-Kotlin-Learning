package com.yey.java.learning;

import org.junit.Test;

import java.util.ArrayList;

class COrder<T> {
    T orderT;

    public COrder(T orderT) {
        this.orderT = orderT;
    }

    // 这个不是泛型方法
    // 他只是与类的泛型参数有关,并不是泛型方法.
    public T getOrderT(T orderT) {
        return orderT;
    }

    // 泛型方法:在方法中出现了泛型结构和泛型参数,与类的泛型参数没有任何的关系.
    // E:代表一个新的泛型,不同于类泛型
    public <E> ArrayList<E> copyArrayToList(E[] arr) {
        ArrayList<E> eArrayList = new ArrayList<>();
        for (E e : arr) {
            eArrayList.add(e);
        }
        return eArrayList;
    }

    // 泛型方法可以是静态的,静态方法中的泛型参数在调用时确定,静态方法泛型参数与静态方法可以同时存在,不存在生命周期冲突.
    // 而静态方法使用泛型类的泛型参数时候, 由于泛型类的泛型参数要晚于静态方法存在,所以存在冲突.
    public static <X> X shopping(X x) {
        return x;
    }

    public <E> E getValue() {
        return null;
    }

}

public class a04泛型方法 {
    @Test
    public void 方法泛型() {
        COrder<Boolean> cOrder = new COrder<Boolean>(true);
        // 泛型方法在调用时指明泛型参数的类型
        ArrayList<Integer> arrayList = cOrder.copyArrayToList(new Integer[]{1, 2, 3, 4});
        for (Integer i : arrayList) {
            System.out.println(i);
        }
        Integer value = cOrder.getValue();
    }
}
