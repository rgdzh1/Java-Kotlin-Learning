package com.yey.shgsa;

public class a03枚举类实现接口 {
    public static void main(String[] args) {
        // 枚举实现接口
        Person1.CHILD.show();
        Person1.STUDENT.show();
    }
}

interface Show {
    void show();
}

// 自定义枚举类
enum Person1 implements Show {
    // 没有属性的自定义枚举类
    STUDENT() {
        @Override
        public void show() {
            System.out.println("学生show");
        }
    },
    CHILD() {
        @Override
        public void show() {
            System.out.println("孩子show");
        }
    };

    @Override
    public void show() {
        System.out.println("普通实现接口");
    }
}