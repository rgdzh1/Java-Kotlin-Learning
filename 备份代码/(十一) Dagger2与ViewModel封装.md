##### 代码示例
```java
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
        // 在调用get的时候才会真的去创建一个tiager对象,这个就是懒加载.
        tigerLazy.get().sleep();
        tigerProvider.get().sleep();
    }
}
```
##### Dagger2生成代码阅读
> 主要分析懒加载的流程逻辑.

就着上面的案例来看下Degger2生成的代码,生成的代码在`build\generated\sources\annotationProcessor\..`文件夹中.
- 当调用`.inject(this)`时,最终调用的代码如下:
```java
final class DaggerZooComponent implements ZooComponent {
    private Provider<Tiger> providerTigerProvider;
    private DaggerZooComponent(ZooModule zooModuleParam) {
      initialize(zooModuleParam);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ZooModule zooModuleParam) {
        // 创建ZooModule_ProviderTigerFactory工厂对象,它的父类是Provider.
        this.providerTigerProvider = ZooModule_ProviderTigerFactory.create(zooModuleParam);
    }
    @Override
    public Zoo inject(Zoo zoo) {
        return injectZoo(zoo);
    }
   private Zoo injectZoo(Zoo instance) {
        // DoubleCheck.lazy(providerTigerProvider):这个是创建一个DoubleCheck对象,该对象的父类有Provider与Lazy.该对象持有providerTigerProvider对象.
        Zoo_MembersInjector.injectTigerLazy(instance, DoubleCheck.lazy(providerTigerProvider));
        // 这一步是为容器也就是Zoo对象中的tigerProvider字段赋值.
        Zoo_MembersInjector.injectTigerProvider(instance, providerTigerProvider);
        return instance;
   } 
}
```
- 看下`DoubleCheck.lazy(providerTigerProvider)`
```java
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    public static <P extends Provider<T>, T> Lazy<T> lazy(P provider) {
      if (provider instanceof Lazy) {
        @SuppressWarnings("unchecked")
        final Lazy<T> lazy = (Lazy<T>) provider;
        ...
        return lazy;
      }
      // 创建DoubleCheck对象.
      return new DoubleCheck<T>(checkNotNull(provider));
    }
}
```
- 在容器中使用`tigerProvider.get()`方法最后调用的是`ZooModule_ProviderTigerFactory.get()`
```java
public final class ZooModule_ProviderTigerFactory implements Factory<Tiger> {
    @Override
    public Tiger get() {
      return providerTiger(module);
    }
    public static Tiger providerTiger(ZooModule instance) {
      // instance.providerTiger():到这一步才开始使用`ZooModule.providerTiger()`创建对象.
      // 从该方法也可以看出,当每调用一次get(),都会生成一个新的Tiger对象
      return Preconditions.checkNotNull(instance.providerTiger(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
```
- 在容器中使用`tigerLazy.get()`方法最后调用的是`DoubleCheck.get()`
```java
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    // 很明显该方法是用来获取单例对象的.所以,当每次调用tigerLazy.get()返回的是一个单例对象.
    @Override
    public T get() {
      Object result = instance;
      if (result == UNINITIALIZED) {
        synchronized (this) {
          result = instance;
          if (result == UNINITIALIZED) {
            // 这里是真实的使用ZooModule_ProviderTigerFactory.get()开始创建tiger对象
            result = provider.get();
            instance = reentrantCheck(instance, result);
            ...
            provider = null;
          }
        }
      }
      return (T) result;
    }
}
```
上面分析了,使用`Lazy`与`Provider`做到懒加载的内部逻辑也揭示了为何`Lazy`类型的对象最终获取的是一个单例对象.