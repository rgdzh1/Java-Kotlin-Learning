package com.yey.dagger2;
import org.junit.Test;
import javax.inject.Inject;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component
interface MvpComponent {
    void inject(View view);
}
class Application {

    public Application() {

    }
}

interface injectP<E> {
    E inject();
}
abstract class BaseP {

}
class P extends BaseP {
    @Inject
    public P() {
    }
}
abstract class BaseView<T extends BaseP, E extends MvpComponent> implements injectP<E> {
    @Inject
    T p;


    public BaseView() {
        inject();
    }

}
class View extends BaseView<P, DaggerMvpComponent> {

    @Override
    public DaggerMvpComponent inject() {
        return null;
    }
}
public class MVP {
    @Test
    public void 开始() {
        View view = new View();
    }
}
