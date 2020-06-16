package com.yey.dagger2;

import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

class Tiger {
    @Inject
    public Tiger() {
    }

    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}

@Singleton
@Component
interface ZooComponent {
    Zoo inject(Zoo zoo);
}

public class Zoo {
    @Inject
    Tiger tiger;

    @Test
    public void 最简单的案例() {
        // DaggerContainerComponent.builder().build().inject(this);
        DaggerZooComponent.create().inject(this);
        tiger.sleep();
    }
}
