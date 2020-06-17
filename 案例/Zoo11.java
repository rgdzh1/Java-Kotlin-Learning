package com.yey.dagger2;

import org.junit.Test;

import java.awt.TextArea;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Component;
import dagger.Lazy;
import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

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

//@Module
//class ZooModule {
//    @Singleton
//    @Provides
//    @IntoSet
//    public Animal providerTiger() {
//        return new Tiger();
//    }
//    @Singleton
//    @Provides
//    @IntoSet
//    public Animal providerCat() {
//        return new Cat();
//    }
//}

@Module
abstract class ZooModule {
    @Singleton
    @IntoSet
    @Binds
    abstract Animal providerTiger(Tiger tiger);
    @Singleton
    @IntoSet
    @Binds
    abstract Animal providerCat(Cat cat);
}

@Singleton
@Component(modules = {ZooModule.class})
interface ZooComponent {
    void inject(Zoo zoo);
}

public class Zoo {
    @Inject
    Set<Animal> set0;
    @Inject
    Set<Animal> set1;
    @Test
    public void 案例十() {
        DaggerZooComponent.create().inject(this);
        System.out.println(set0.hashCode());
        set0.forEach(new Consumer<Animal>() {
            @Override
            public void accept(Animal animal) {
                animal.sleep();
            }
        });
        System.out.println(set1.hashCode());
        set1.forEach(new Consumer<Animal>() {
            @Override
            public void accept(Animal animal) {
                animal.sleep();
            }
        });
    }
}
