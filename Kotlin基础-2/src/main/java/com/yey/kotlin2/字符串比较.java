package com.yey.kotlin2;

public class 字符串比较 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String(new char[]{'a', 'b', 'c'});
        System.out.println("======开始输出=======");
        System.out.println(str1.equals(str2));// 比较值
        System.out.println(str1 == str2);// 比较地址值
    }
}
