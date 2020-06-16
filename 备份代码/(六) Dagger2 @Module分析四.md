##### 代码示例
```java
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
// 对象使用者
public class Zoo {
    // @Inject: 该注解用于成员变量上代表注射器可以为该成员变量赋值对象.
    @Inject
    Tiger tiger;

    @Test
    public void 案例六() {
        // ZooModule中的成员food无法通过Dagger2自动生成,需要用户手动创建.
        DaggerZooComponent.builder().zooModule(new ZooModule(new Food())).build().inject(this);
        tiger.sleep();
    }
}
// 注射器
// @Component: 该注解是用来创造对象提供方和对象使用间的桥梁,如何将对象赋值给使用者的成员变量都是由它来做的.
@Component(modules = {ZooModule.class})
interface ZooComponent {
    Zoo inject(Zoo zoo);
}
```
##### Dagger2生成代码阅读
> 主要分析Module中依赖某个无法使用Dagger2创建的对象,该如何将该对象加入注射器中?
> 类似情况很常见,比如Activity由系统创建,假如某个Module依赖Activity对象,那Dagger2如何处理它们的依赖关系.

就着上面的案例来看下Degger2生成的代码,生成的代码在`build\generated\sources\annotationProcessor\..`文件夹中.

1. `DaggerZooComponent.builder().zooModule(new ZooModule(new Food())).build()`
创建`DaggerZooComponent`对象,这里主要看下`zooModule(new ZooModule(new Food()))`如何处理的.
```java
final class DaggerZooComponent implements ZooComponent {
    // 工厂对象
    private final ZooModule zooModule;
    // DaggerZooComponent构造方法
    private DaggerZooComponent(ZooModule zooModuleParam) {
        this.zooModule = zooModuleParam;
    }
    public static Builder builder() {
        // 创建DaggerZooComponent.Builder对象
        return new Builder();
    }
    static final class Builder {
        private ZooModule zooModule;
        private Builder() {
        }
        // 创建ZooModule对象
        public Builder zooModule(ZooModule zooModule) {
          this.zooModule = Preconditions.checkNotNull(zooModule);
          return this;
        }
        public ZooComponent build() {
          Preconditions.checkBuilderRequirement(zooModule, ZooModule.class);
          // 创建DaggerZooComponent对象,它持有ZooModule引用
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
        // 1. ZooModule_ProviderTigerFactory.providerTiger(zooModule): 通过ZooModule工厂获取Zoo需要的Tiger对象.
        // 2. Zoo_MembersInjector.injectTiger(instance, getTiger()): 这里就是为Zoo对象中所需字段赋值.
        Zoo_MembersInjector.injectTiger(instance, ZooModule_ProviderTigerFactory.providerTiger(zooModule));
        return instance;
    }
}
```
3. `ZooModule_ProviderTigerFactory.providerTiger(zooModule)`
```java
public final class ZooModule_ProviderTigerFactory implements Factory<Tiger> {
    public static Tiger providerTiger(ZooModule instance) {
      // providerTiger()为用户在ZooModule中实现的方法,用来返回Tiger对象.
      return Preconditions.checkNotNull(instance.providerTiger(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
```
4. 赋值
`Zoo_MembersInjector.injectTiger(instance, ZooModule_ProviderTigerFactory.providerTiger(zooModule));`
```java
public final class Zoo_MembersInjector implements MembersInjector<Zoo> {
   public static void injectTiger(Zoo instance, Object tiger) {
     instance.tiger = (Tiger) tiger;
   } 
}
```
如果`Foot`无法通过`Dagger2`自行创建加入注射器中的话,可以用户手动创建一个`Foot`对象,再通过`Module`构造将该对象传入`Module`中,然后交给`Module`工厂方法使用.