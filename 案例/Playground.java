package com.yey.dagger2;

import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

//class Food {
//    public Food() {
//    }
//}

class Tiger {
    // 假如老虎需要食物
//    Food food;

//    public Tiger(Food food) {
//        this.food = food;
//    }

    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}

//@Module
//class FoodModule {
//    @Provides
//    public Food providerFood() {
//        return new Food();
//    }
//}

@Module
class ZooModule {
    @Provides
    public Tiger providerTiger() {
        return new Tiger();
    }
}

@Component(modules = {ZooModule.class})
interface ZooComponent {
    Tiger provider();
}

@Component(dependencies = {ZooComponent.class})
interface PlaygroundComponent {
    Playground inject(Playground playground);
}

public class Playground {
    @Inject
    Tiger tiger;

    @Test
    public void 最简单的案例() {
        ZooComponent zooComponent = DaggerZooComponent.create();
        DaggerPlaygroundComponent.builder().zooComponent(zooComponent).build().inject(this);
        tiger.sleep();
    }
}
