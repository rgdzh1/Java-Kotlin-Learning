package com.yey.shgsa;

@interface MyAnnotation {
    // 只有一个成员
    String value() default "hello"; // 这个是属性
}

@MyAnnotation(value = "点击") // 为value 赋值
public class a05自定义注解 {
    /**
     * 自定义注解参照@SuppressWarnings来定义
     * 1. 注解声明为: @interface
     * 2. 内部定义成员使用value()
     * 3. 可以指定成员的默认值,使用default "hello"
     * 4. 如果自定义注解没有成员,表明是一个标识作用
     */
}
