package com.yey.dagger2;

import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Component;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

abstract class Animal {
    abstract void sleep();
}

class Tiger extends Animal {
    @Inject
    public Tiger() {
    }

    @Override
    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}
class Cat extends Animal {
    @Inject
    public Cat() {
    }

    @Override
    public void sleep() {
        System.out.println("Cat sleeping");
    }
}


@Module
abstract class ZooModule {
    // 这样写是可以的,但是容器中使用的时候需要明确类型接收,不能用父类去接收了.
    @Binds
    abstract Animal bindTiger(Tiger tiger);

    @Binds
    abstract Animal bindCat(Cat cat);
}

@Component(modules = {ZooModule.class})
interface ZooComponent {
    Zoo inject(Zoo zoo);
}

public class Zoo {
    @Inject
    Tiger tiger;

    @Test
    public void 案例十() {
        DaggerZooComponent.create().inject(this);
        tiger.sleep();
    }
}
