package com.yey.dagger2;

import org.junit.Test;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

class Food {
}

class Tiger {
    // 假如老虎需要食物
    Food food;

    public Tiger(Food food) {
        this.food = food;
    }

    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}

// 为注射器提供工厂类
// @Module: 表示Dagger2可以将该类当作对象工厂.
@Module
class ZooModule {
    private Food food;

    public ZooModule(Food food) {
        this.food = food;
    }

    // @Provides: 表示Dagger2可以调用providerTiger(Food food)方法为注射器提供对象.
    @Provides
    public Tiger providerTiger() {
        return new Tiger(food);
    }
}

// 注射器
// @Component: 该注解是用来创造对象提供方和对象使用间的桥梁,如何将对象赋值给成员变量都是由它来做的.
@Component(modules = {ZooModule.class})
interface ZooComponent {
    Zoo inject(Zoo zoo);
}

// 对象使用者
public class Zoo {
    // @Inject: 该注解用于成员变量上代表注射器可以为该成员变量赋值对象.
    @Inject
    Tiger tiger;

    @Test
    public void 案例六() {
        DaggerZooComponent.builder().zooModule(new ZooModule(new Food())).build().inject(this);
        tiger.sleep();
    }
}
