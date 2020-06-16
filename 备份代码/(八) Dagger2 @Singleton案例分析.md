##### 代码示例
```java
class Tiger {
    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}
@Module
class ZooModule {
    @Singleton // 注意这里
    @Provides
    public Tiger providerTiger() {
        return new Tiger();
    }
}
@Singleton // 注意这里
@Component(modules = {ZooModule.class})
interface ZooComponent {
    Zoo inject(Zoo zoo);
}
public class Zoo {
    @Inject
    Tiger tiger;
    @Test
    public void 案例八() {
        DaggerZooComponent.create().inject(this);
        tiger.sleep();
    }
}
```
##### Dagger2生成代码阅读
> 主要分析加了`@Singleton`注解之后,`Tiger`对象在同一个注射器生命周期中是一个单例对象.

就着上面的案例来看下Degger2生成的代码,生成的代码在`build\generated\sources\annotationProcessor\..`文件夹中.

1. `DaggerZooComponent.create()`
```java
final class DaggerZooComponent implements ZooComponent {
    private Provider<Tiger> providerTigerProvider;
    private DaggerZooComponent(ZooModule zooModuleParam) {
        // 该方法最终创建一个Provider对象,它持有ZooModule_ProviderTigerFactory对象.
        initialize(zooModuleParam);
    }
    private void initialize(final ZooModule zooModuleParam) {
        // ZooModule_ProviderTigerFactory.create(zooModuleParam)创建一个ZooModule_ProviderTigerFactory对象,它的父类其实是Provider.
        // DoubleCheck.provider():创建DoubleCheck对象.
        this.providerTigerProvider = DoubleCheck.provider(ZooModule_ProviderTigerFactory.create(zooModuleParam));
    }
    static final class Builder {
        private ZooModule zooModule;
        private Builder() {
        }
        public Builder zooModule(ZooModule zooModule) {
          this.zooModule = Preconditions.checkNotNull(zooModule);
          return this;
        }
        // 创建注射器对象
        public static ZooComponent create() {
            return new Builder().build();
        }
        public ZooComponent build() {
          if (zooModule == null) {
            // ZooModule对象在这里被创建
            this.zooModule = new ZooModule();
          }
          // 创建注射器对象DaggerZooComponent.
          return new DaggerZooComponent(zooModule);
        }
    }
}
```
2. 注入对象前需要弄清除`DoubleCheck.provider()`
首先看`ZooModule_ProviderTigerFactory.create(zooModuleParam)`
```java
public final class ZooModule_ProviderTigerFactory implements Factory<Tiger> {
    // 该方法主要用来创建ZooModule_ProviderTigerFactory对象,它的父类其实是Provider.
    public static ZooModule_ProviderTigerFactory create(ZooModule module) {
      return new ZooModule_ProviderTigerFactory(module);
    }
}
```
再看下`DoubleCheck.provider()`
```java
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    public static <P extends Provider<T>, T> Provider<T> provider(P delegate) {
      ...
      // delegate:是ZooModule_ProviderTigerFactory对象,他的父类是Provider.
      return new DoubleCheck<T>(delegate);
    }
    // 它最终将ZooModule_ProviderTigerFactory对象存储起来了.
    private DoubleCheck(Provider<T> provider) {
      assert provider != null;
      this.provider = provider;
    }
}
```
3. `.inject(this)`
```java
final class DaggerZooComponent implements ZooComponent {
    @Override
    public Zoo inject(Zoo zoo) {
        return injectZoo(zoo);
    }
    private Zoo injectZoo(Zoo instance) {
        // providerTigerProvider.get():这里是Tiger对象单例的关键所在
        // Zoo_MembersInjector.injectTiger():真实的赋值动作在该方法中
        Zoo_MembersInjector.injectTiger(instance, providerTigerProvider.get());
        return instance;
    }
}
```
4. `providerTigerProvider.get()`
上面分析过`providerTigerProvider`是一个`Provider`对象,它持有`ZooModule_ProviderTigerFactory`对象,下面先看`Provider.get()`
```java
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    private DoubleCheck(Provider<T> provider) {
      assert provider != null;
      this.provider = provider; // 该变量为ZooModule_ProviderTigerFactory对象.
    }
    @Override
    public T get() {
      Object result = instance;
      if (result == UNINITIALIZED) {
        synchronized (this) {
          result = instance;
          if (result == UNINITIALIZED) {
            // 经过双重判断,如果result为null,
            // 那么就调用ZooModule_ProviderTigerFactory.get()获取tiger对象赋值给result变量
            result = provider.get();
            instance = reentrantCheck(instance, result);
            provider = null;
          }
        }
      }
      // 最终将tiger对象返回
      return (T) result;
    }
}
```
5. `ZooModule_ProviderTigerFactory.get()`
```java
public final class ZooModule_ProviderTigerFactory implements Factory<Tiger> {
    @Override
    public Tiger get() {
      return providerTiger(module);
    }
    public static Tiger providerTiger(ZooModule instance) {
      //  ZooModule_ProviderTigerFactory.get()最终调用的方法是 ZooModule.providerTiger(),最终返回Module创建的tiger对象.
      return Preconditions.checkNotNull(instance.providerTiger(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
```
6. `Zoo_MembersInjector.injectTiger(instance, providerTigerProvider.get())`
最终的赋值动作在该方法中
```java
public final class Zoo_MembersInjector implements MembersInjector<Zoo> {
    @InjectedFieldSignature("com.yey.dagger2.Zoo.tiger")
    public static void injectTiger(Zoo instance, Object tiger) {
      instance.tiger = (Tiger) tiger;
    }
}
```
##### 总结
1. 当`Module`中增加了`@Singleton`注解,那么依赖该`Module`的注射器也得增加`@Singleton`注解,否则报错.
2. `Module`中方法增加`@Singleton`注解,当前方法返回的对象时,会对该返回的对象进行双重检查,保证该对象是单例.
3. `@Singleton`注解是与每个注射器的生命周期同步,两个不同的注射器其实会创建两个`tiger`对象,但是在同一个注射器下,`tiger`对象才是单例.

##### 注射器相互依赖时使用`@Scope`
```java
class Tiger {
    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}
@Module
class ZooModule {
    // 表示Tiger对象是单例.
    @Singleton
    @Provides
    public Tiger providerTiger() {
        return new Tiger();
    }
}
// ZooComponent注射器使用了@Singleton,当另外一个注射器依赖它时,也需要添加一个@Scope类型注释.
@Singleton 
@Component(modules = {ZooModule.class})
interface ZooComponent {
    Tiger provider();
}
// 假如PlaygroundComponent注射器依赖ZooComponent注射器,因为ZooComponent有@Singleton注释,
// 所以PlaygroundComponent注射器也必须增加一个Scope注释,并且不允许和@Singleton注释相同,
// 那么只有自定义一个@MyScope注释
@MyScope
@Component(dependencies = {ZooComponent.class})
interface PlaygroundComponent {
    Playground inject(Playground playground);
}
//自定义一个MyScope注释
@Scope
@Documented
@Retention(RUNTIME)
public @interface MyScope {}
```
其实`@Singleton`注释和`@MyScope`功能是一样的,只是名字不同而已,上面的代码中将他们两个调换完全可以.在同一个注射器的生命周期范围里,用`@Singleton`标注的方法获取到的对象是一个单例.
