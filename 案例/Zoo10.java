package com.yey.dagger2;

import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

class Tiger {
    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}
@Module
class ZooModule {
    @Provides
    public Tiger providerTiger() {
        return new Tiger();
    }
}
@Component(modules = {ZooModule.class})
interface ZooComponent {
    Zoo inject(Zoo zoo);
}
public class Zoo {
    @Inject
    Lazy<Tiger> tigerLazy;
    @Inject
    Provider<Tiger> tigerProvider;
    @Test
    public void 案例十() {
        DaggerZooComponent.create().inject(this);
        tigerLazy.get().sleep();
        tigerProvider.get().sleep();
    }
}
