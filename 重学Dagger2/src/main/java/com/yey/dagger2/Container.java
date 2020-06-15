package com.yey.dagger2;

import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

class User {
    @Inject
    public User() {
    }

    public void eat() {
        System.out.println("打印方法");
    }
}

@Singleton
@Component
interface ContainerComponent {
    Container inject(Container container);
}

public class Container {
    @Inject
    User user;

    @Test
    public void 最简单的案例() {
        // DaggerContainerComponent.builder().build().inject(this);
        DaggerContainerComponent.create().inject(this);
        user.eat();
    }
}
