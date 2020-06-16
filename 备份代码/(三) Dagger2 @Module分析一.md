##### 代码示例
```java
class Tiger {
    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}
// 为注射器提供工厂类
// @Module: 表示Dagger2可以将该类当作对象工厂.
@Module
class ZooModule {
    // @Provides: 表示Dagger2可以调用providerTiger()方法为注射器提供对象.
    @Provides
    public Tiger providerTiger() {
        return new Tiger();
    }
    
    // Tips: 如果当前工厂或者其他工厂为同一个注射器提供相同的对象,编译的时候会提示重复绑定的错误.
    // [Dagger/DuplicateBindings] 
    @Provides
    public Tiger providerTiger2() {
        return new Tiger();
    }

}
// 对象使用者
public class Zoo {
    // @Inject: 该注解用于成员变量上代表注射器可以为该成员变量赋值对象.
    @Inject
    Tiger tiger;

    @Test
    public void 案例三() {
        DaggerZooComponent.create().inject(this);
        tiger.sleep();
    }
}
// 注射器
// @Component: 该注解是用来创造对象提供方和对象使用间的桥梁,如何将对象赋值给成员变量都是由它来做的.
// (modules = {ZooModule.class}): 表示该注射器可以使用ZooModule对象工厂提供方法.
@Component(modules = {ZooModule.class})
interface ZooComponent {
    Zoo inject(Zoo zoo);
}
```
##### Dagger2生成代码阅读
> 主要分析的是`@Module`,`@Provides`注解作为对象工厂给注射器使用.

就着上面的案例来看下Degger2生成的代码,生成的代码在`build\generated\sources\annotationProcessor\..`文件夹中.
1. `DaggerZooComponent.create()`
`create()`用来生成`DaggerZooComponent`对象,`DaggerZooComponent`的父类是`ZooComponent`接口,它重写了接口中的`inject()`方法.
```java
final class DaggerZooComponent implements ZooComponent {
    private final ZooModule zooModule;
    // 由Builder.build()创建DaggerZooComponent对象.
    private DaggerZooComponent(ZooModule zooModuleParam) {
      this.zooModule = zooModuleParam;
    }
    // create()方法创建DaggerZooComponent()对象
    public static ZooComponent create() {
      return new Builder().build();
    }
    
    static final class Builder {
        private ZooModule zooModule;
        private Builder() {
        }
        // build()方法返回DaggerZooComponent对象.  
        public ZooComponent build() {
            // 如果zooModule为null,那么就创建该对象.ZooModule代表工厂.
            if (zooModule == null) {
              this.zooModule = new ZooModule();
            }
            // 将ZooModule工厂对象存储在DaggerZooComponent对象中
            return new DaggerZooComponent(zooModule);
        }
    }
}
```
2. `.inject(this)`对象注入
使用`DaggerZooComponent`对象将`Dagger2`创建的`Tiger`对象注入到`Zoo`中.
```java
final class DaggerZooComponent implements ZooComponent {
    // 接口中的方法,由DaggerZooComponent实现,该方法就是用来向Zoo对象中注入Tiger对象的.
    @Override
    public Zoo inject(Zoo zoo) {
        // zoo就是inject(this)中的this了,代表Zoo对象.
        return injectZoo(zoo);
    }

    private Zoo injectZoo(Zoo instance) {
        // 1. ZooModule_ProviderTigerFactory.providerTiger(zooModule): 通过ZooModule工厂获取Zoo需要的对象.
        // 2. Zoo_MembersInjector.injectTiger(instance, ZooModule_ProviderTigerFactory.providerTiger(zooModule)): 这里就是为Zoo对象中所需字段赋值.
        Zoo_MembersInjector.injectTiger(instance, ZooModule_ProviderTigerFactory.providerTiger(zooModule));
        return instance;
    }
}
```
3. `ZooModule_ProviderTigerFactory.providerTiger(zooModule)`
上面讲过,`ZooModule`其实是工厂,专门为`Dagger2`提供对象用的,下面就能看到`ZooModule`提供对象的操作.
```java
public final class ZooModule_ProviderTigerFactory implements Factory<Tiger> {
    public static Tiger providerTiger(ZooModule instance) {
        // providerTiger()为用户在ZooModule类中写的方法,返回一个Tiger对象.
        // Preconditions.checkNotNull() 该方法最终将Tiger对象返回
        return Preconditions.checkNotNull(instance.providerTiger(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
```
4. `Zoo_MembersInjector.injectTiger(instance, ZooModule_ProviderTigerFactory.providerTiger(zooModule))`
该方法为`Zoo`对象中所需字段赋值,`instance`为`Zoo`对象,`ZooModule_ProviderTigerFactory.providerTiger(zooModule)`将返回`Tiger`对象.
```java
public final class Zoo_MembersInjector implements MembersInjector<Zoo> {
    @InjectedFieldSignature("com.yey.dagger2.Zoo.tiger")
    public static void injectTiger(Zoo instance, Object tiger) {
        // 此处就是为zoo.tiger字段赋值的操作.
        instance.tiger = (Tiger) tiger;
    }
}
```