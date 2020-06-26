package com.yey.mmk;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.MalformedParametersException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.ExecutionException;


// 这是注解
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE})
@interface MyAnnotaion {
    String value() default "hellow";
}

class Persona05 {

    public void eat() {
    }

    private void run() {
    }

    protected void play() {
    }
}

class Studenta05 extends Persona05 {
    @Deprecated
    @MyAnnotaion
    public boolean study() {
        return false;
    }

    private void read(String name, int time) throws NullPointerException, MalformedParametersException {
    }

    protected void footBall() {
    }
}

public class a05反射获取方法 {
    @Test
    public void 反射获取方法1() {
        Class<Studenta05> studenta05Class = Studenta05.class;
        // getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        // 结果是只能获取到:Studenta05.study()与Persona05.eat(),因为不是public方法获取不到
        Method[] methods = studenta05Class.getMethods();
        for (Method m :
                methods) {
            System.out.println(m);
        }
    }

    @Test
    public void 反射获取方2() {
        Class<Studenta05> studenta05Class = Studenta05.class;
        // getDeclaredMethods(): 获取当前运行时类中声明的所有方法(不包含父类的方法)
        // 当前运行时类中的方法都能获取到,不论是public private protected 这些权限修饰的方法都能获取到.
        Method[] methods = studenta05Class.getDeclaredMethods();
        for (Method m :
                methods) {
            System.out.println(m);
        }
    }

    /**
     * 方法结构
     * 权限修饰符 返回值类型 方法名(参数类型1 形参1,...) throw xxxException{}
     */
    @Test
    public void 获取方法声明的注解() {
        Class<Studenta05> studenta05Class = Studenta05.class;
        Method[] declaredMethods = studenta05Class.getDeclaredMethods();
        for (Method m : declaredMethods) {
            // 一个方法可以获取多个注解,所以获取到的注解是一个数组
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                System.out.print(a);
            }
        }
    }

    @Test
    public void 获取方法权限修饰符() {
        Class<Studenta05> studenta05Class = Studenta05.class;
        Method[] declaredMethods = studenta05Class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            // 获取方法权限修饰符
            System.out.println(Modifier.toString(method.getModifiers()));
        }
    }

    @Test
    public void 获取方法返回值类型() {
        Class<Studenta05> studenta05Class = Studenta05.class;
        Method[] declaredMethods = studenta05Class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Class<?> returnType = method.getReturnType();
            String name = returnType.getName();
            System.out.println(name);
        }
    }

    @Test
    public void 获取方法方法名称() {
        Class<Studenta05> studenta05Class = Studenta05.class;
        Method[] declaredMethods = studenta05Class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            String name = method.getName();
            System.out.println(name);
        }
    }

    @Test
    public void 获取方法形参列表() {
        Class<Studenta05> studenta05Class = Studenta05.class;
        Method[] declaredMethods = studenta05Class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (Class c : parameterTypes) {
                    // 上面的方法中,只有Studenta05.read()方法有参数.
                    System.out.println(c.getName());
                }
            }
        }
    }

    @Test
    public void 获取方法抛出的异常() {
        Class<Studenta05> studenta05Class = Studenta05.class;
        Method[] declaredMethods = studenta05Class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (!(exceptionTypes == null && exceptionTypes.length == 0)) {
                for (Class c : exceptionTypes) {
                    System.out.println(c.getName());
                }
            }
        }
    }


}
