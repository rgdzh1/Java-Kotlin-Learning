package com.yey.dagger2;


import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

class Tiger {
    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}

@Module
class ZooModule {
    @Singleton
    @Provides
    public Tiger providerTiger() {
        return new Tiger();
    }
}

@Singleton
@Component(modules = {ZooModule.class})
interface ZooComponent {
    Tiger provider();
}

@MyScope
@Component(dependencies = {ZooComponent.class})
interface PlaygroundComponent {
    Playground inject(Playground playground);
}


public class Playground {
    @Inject
    Tiger tiger;

    @Test
    public void 案例九() {
        ZooComponent zooComponent = DaggerZooComponent.create();
        DaggerPlaygroundComponent.builder().zooComponent(zooComponent).build().inject(this);
        tiger.sleep();
    }
}
