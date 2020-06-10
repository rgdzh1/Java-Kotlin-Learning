package com.yey.dagger2;

import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

class User {
    @Inject
    public User() {
    }

    public void 方法() {
        System.out.println("打印方法");
    }
}

@Singleton
@Component
interface 注射器 {
    Container 将对象注入容器(Container container);
}

public class Container {
    @Inject
    User user;

    @Test
    public void 最简单的案例() {
        // Dagger注射器.builder().build().将对象注入容器(this);
        Dagger注射器.create().将对象注入容器(this);
        user.方法();
    }
}
