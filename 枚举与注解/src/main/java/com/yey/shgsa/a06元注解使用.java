package com.yey.shgsa;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 必须加上RUNTIME才能通过反射获取到这个注解
@Target(ElementType.TYPE)
@Inherited
//使注解有继承性
@interface TestAnnotation {
    String value() default "a";
}

@TestAnnotation
class My {
}

class MyAnnotaitonTest extends My {
}

public class a06元注解使用 {
    /**
     * 元注解: 用于修饰其他的注解
     * 元数据: 对现有数据进行修饰的数据
     */
    /**
     * 元注解:
     * Retention:指定所修饰注解的声明周期,有三种
     * SOURCE: 在字节码中不会保留该注解信息
     * CLASS: 该注解会被保留在字节码文件中,但是不会加载到内存里.也就是反编译Class字节码文件是可以看到该注解信息的.一般注解没有声明生命周期的话默认就是CLASS.
     * RUNTIME: 会被加载到JVM虚拟机内存中
     * 只有声明为RUNTIME生命周期的注解才能通过反射获取.
     *
     * @Target : 用于指定被修饰的注解能用于修饰那些程序的元素,比如字段方法等ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE
     * @Documented: 表示所修饰的注解在被JavaDoc解析时, 保留下来.
     * @Inherited: 被它修饰的Annotation将具有继承性, 子类可以继承父类的注解
     */

    @Test
    public void 测试注解继承性() {
        Class<MyAnnotaitonTest> myAnnotaitonTestClass = MyAnnotaitonTest.class;
        Annotation[] annotations = myAnnotaitonTestClass.getAnnotations();
        for (Annotation a :
                annotations) {
            System.out.println(a);
        }
    }

}
