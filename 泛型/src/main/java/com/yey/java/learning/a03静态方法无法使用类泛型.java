package com.yey.java.learning;

class BOrder<T> {
    T orderT;

    public BOrder(T orderT) {
        this.orderT = orderT;
    }

    // 静态方法是不能使用类泛型的
    // 因为类泛型是在类的创建时候指定的,而静态方法要早于对象的创建.
//    public static void printT(T orderT) {
//        System.out.println(orderT);
//    }
}

public class a03静态方法无法使用类泛型 {

}
