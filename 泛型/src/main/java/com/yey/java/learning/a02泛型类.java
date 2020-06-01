package com.yey.java.learning;

import org.junit.Test;

// 父类
class AOrder<T> {
    T orderT;

    public AOrder(T orderT) {
        this.orderT = orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
}
// 子类1
class SubAOrder1 extends AOrder<Integer> {// SubOrder1不再是泛型类
    public SubAOrder1(Integer orderT) {
        super(orderT);
    }
}
// 子类2
class SubAOrder2<T> extends AOrder<T> {// SubOrder2 仍然是泛型类
    public SubAOrder2(T orderT) {
        super(orderT);
    }
}
public class a02泛型类 {
    @Test
    public void 泛型类() {
        // 如果定义了类泛型,而实例化时没有指明类的泛型,则认为此泛型类型为Object类型
        // 要求:如果指定了类带泛型,则实例化时要指明类的泛型.
        AOrder order1 = new AOrder("a");
        order1.setOrderT(100);// 此时泛型为Object类型
        // 这样才是对的
        AOrder<Boolean> order3 = new AOrder<>(true);
        order3.setOrderT(false);// 此时泛型为Boolean
    }

    @Test
    public void 泛型子父类(){
        // SubOrder1不再是泛型类, 父类的泛型已经指定了为Integer,则子类实例化时,不再需要去重新指定泛型了.
        SubAOrder1 subOrder1 = new SubAOrder1(1000);
        subOrder1.setOrderT(2046);

        // SubOrder2还是泛型类,因为父类没有指定泛型,子类实例化最好指定泛型
        SubAOrder2<String> subOrder2 = new SubAOrder2<>("Tom");
        subOrder2.setOrderT("Aili");

    }
}
