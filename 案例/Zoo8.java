package com.yey.dagger2;

import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

//class Food {
//}

class Tiger {
    // 假如老虎需要食物
//    Food food;
//
//    public Tiger(Food food) {
//        this.food = food;
//    }

    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}

@Module
class ZooModule {
//    private Food food;
//
//    public ZooModule(Food food) {
//        this.food = food;
//    }

    @Singleton
    @Provides
    public Tiger providerTiger() {
        return new Tiger();
    }
}
@Singleton
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
    public void 案例八() {
        DaggerZooComponent.create().inject(this);
        tiger.sleep();
    }
}
