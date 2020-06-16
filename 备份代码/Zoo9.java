package com.yey.dagger2;

import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

class Tiger {
    String name;

    public Tiger(String name) {
        this.name = name;
    }

    public Tiger() {
    }

    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}

@Module
class ZooModule {

    @Tiger1
    @Provides
    public Tiger providerTiger_1() {
        return new Tiger();
    }

    @Tiger2
    @Provides
    public Tiger providerTiger_2() {
        return new Tiger("米饭");
    }
}

@Component(modules = {ZooModule.class})
interface ZooComponent {
    Zoo inject(Zoo zoo);
}

public class Zoo {
    // 使用自定义Qualifier注解,用以区分tiger1到底使用哪个对象.
    @Tiger1
    @Inject
    Tiger tiger1;
    @Tiger2
    @Inject
    Tiger tiger2;

    @Test
    public void 案例九() {
        DaggerZooComponent.create().inject(this);
        tiger1.sleep();
        tiger2.sleep();
    }
}
