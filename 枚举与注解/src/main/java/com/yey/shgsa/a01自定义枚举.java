package com.yey.shgsa;

public class a01自定义枚举 {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        System.out.println(autumn);
    }
}

// 自定义枚举类
enum Season {
    // 提供多个枚举类对象
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天");
    // 1. 声明Season对象的属性,必须使用private final修饰
    private final String seasonName;

    // 2. 私有化类的构造器,并给对象属性赋值
    private Season(String seasonName) {
        this.seasonName = seasonName;
    }

    // 可以使用get方法
    public String getSeasonName() {
        return seasonName;
    }
}