package com.yey.shgsa;

public class a02枚举类中常用方法 {
    /**
     * Enum类中常用的方法
     * values()方法:返回枚举类型的对象数据,该方法可以方便的遍历枚举类中的所有枚举值.
     * valueOf(String name): 传递枚举类型的Calss对象和枚举常量名称给静态方法valueOf, 会得到与参数匹配的枚举常量
     * toString(): 得到当前枚举常量的名称
     * equals() 在枚举类型中可以直接使用"=="来比较两个枚举常量是否相等,
     * ordinal() 得到当前枚举常量的次序
     */
    public static void main(String[] args) {
//        Season[] values = Season.values();
//        for (Season s :
//                values) {
//            System.out.println(s.name());
//        }
        Season spring = Season.valueOf("SPRING");
        System.out.println(spring);
    }
}

// 自定义枚举类
enum Person {
    // 没有属性的自定义枚举类
    STUDENT,
    CHILD;
}