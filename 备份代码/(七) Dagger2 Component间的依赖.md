##### 代码示例
假如`PlaygroundComponent`注射器需要`ZooComponent`提供对象.
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
}
// 注射器
// @Component: 该注解是用来创造对象提供方和对象使用间的桥梁,如何将对象赋值给成员变量都是由它来做的.
@Component(modules = {ZooModule.class})
interface ZooComponent {
    // 表示ZooComponent注射器可以向其他注射器提供ZooModule工厂类中的方法,也就是提供ZooModule工厂中创建的对象.
    Tiger providerTiger();
}

// 注射器
// dependencies: 表示PlaygroundComponent注射器依赖ZooComponent注射器,
// ZooComponent注射器向PlaygroundComponent注射器提供ZooModule工厂创建的Tiger对象.
@Component(dependencies = {ZooComponent.class})
interface PlaygroundComponent {
    Playground inject(Playground zoo);
}


// 对象使用者
public class Playground {
    // @Inject: 该注解用于成员变量上代表注射器可以为该成员变量赋值对象.
    @Inject
    Tiger tiger;

    @Test
    public void 案例七() {
        // 创建ZooComponent注射器对象
        ZooComponent zooComponent = DaggerZooComponent.create();
        // DaggerPlaygroundComponent注射器依赖ZooComponent注射器,所以使用zooComponent()将ZooComponent注射器对象传入DaggerPlaygroundComponent注射器中.
        // 创建好DaggerPlaygroundComponent对象之后调用inject()方法为Playground对象中注入Tiger对象.
        DaggerPlaygroundComponent.builder().zooComponent(zooComponent).build().inject(this);
        tiger.sleep();
    }
}
```
##### Dagger2生成代码阅读
> 主要分析注射器之间产生依赖关系后,一个注射器如何才能使用其他注射器中的对象.

就着上面的案例来看下Degger2生成的代码,生成的代码在`build\generated\sources\annotationProcessor\..`文件夹中.

1. `ZooComponent`注射器对象的创建
`ZooComponent`依赖了`ZooModule`
```java
final class DaggerZooComponent implements ZooComponent {
    private final ZooModule zooModule;
    public static ZooComponent create() {
        // 这里最终调用的是Builder.build(),然后回创建ZooComponent对象.
        return new Builder().build();
    }
    static final class Builder {
        private Builder() {
        }
        public ZooComponent build() {
            if (zooModule == null) {
              // 依赖的ZooModule对象在此处创建
              this.zooModule = new ZooModule();
            }
            // DaggerZooComponent在这里被创建,它持有zooModule引用,zooModule是一个工厂类,里面提供了创建Tiger对象的方法.
            return new DaggerZooComponent(zooModule);
        }
    }
}
```
2. `DaggerPlaygroundComponent`对象的创建
`DaggerPlaygroundComponent`依赖`DaggerZooComponent`注射器
    - `DaggerPlaygroundComponent.builder()`
    创建`DaggerPlaygroundComponent`中的内部类`Builder`对象
    ```java
       final class DaggerPlaygroundComponent implements PlaygroundComponent {
           public static Builder builder() {
               return new Builder();
           }
           static final class Builder {
               private Builder() {
               }
           }
       }
    ```
    - `DaggerPlaygroundComponent.Builder.zooComponent(zooComponent)`
    为`DaggerPlaygroundComponent.Builder`对象设置`zooComponent`注射器对象.
    ```java
       final class DaggerPlaygroundComponent implements PlaygroundComponent {
           private ZooComponent zooComponent;
           static final class Builder {
               // 为Builder对象设置ZooComponent对象
               public Builder zooComponent(ZooComponent zooComponent) {
                 this.zooComponent = Preconditions.checkNotNull(zooComponent);
                 return this;
               }
           }
       }
    ```
    - `DaggerPlaygroundComponent.Builder.build()`
    创建`DaggerPlaygroundComponent`对象
    ```java
       final class DaggerPlaygroundComponent implements PlaygroundComponent {
           static final class Builder {
               public PlaygroundComponent build() {
                   Preconditions.checkBuilderRequirement(zooComponent, ZooComponent.class);
                   // 创建DaggerPlaygroundComponent对象,它持有zooComponent引用
                   return new DaggerPlaygroundComponent(zooComponent);
               }
           } 
       }
    ```
3. 为`Playground`对象注入`Tiger`对象
`DaggerPlaygroundComponent.inject(this)`
```java
final class DaggerPlaygroundComponent implements PlaygroundComponent {
    private final ZooComponent zooComponent;// ZooComponent注射器
    @Override
    public Playground inject(Playground zoo) {
        // playground被注入的容器
        return injectPlayground(zoo);
    }
    
    private Playground injectPlayground(Playground instance) {
        // zooComponent.providerTiger(): 获取Tiger对象,这个就是在zooComponent注射器中定义的接口方法.具体的实现在DaggerZooComponent类中.
        // Playground_MembersInjector.injectTiger(instance,tiger): 具体赋值操作在这个地方.
        Playground_MembersInjector.injectTiger(instance, Preconditions.checkNotNull(zooComponent.providerTiger(), "Cannot return null from a non-@Nullable component method"));
        return instance;
    }
}
```
4. 如何从依赖的注射器`ZooComponent`中获取`Tiger`对象
具体的实现在`DaggerZooComponent`中,`DaggerZooComponent`中持有`ZooModule`工厂类.
```java
final class DaggerZooComponent implements ZooComponent {
    private final ZooModule zooModule;
    @Override
    public Tiger providerTiger() {
      // 接着向下看  
      return ZooModule_ProviderTigerFactory.providerTiger(zooModule);
    }
}
public final class ZooModule_ProviderTigerFactory implements Factory<Tiger> {
    // instance代表ZooModule工厂对象
    // providerTiger()方法就是在ZooModule类中用户定义的方法了,该方法返回Tiger对象.
    public static Tiger providerTiger(ZooModule instance) {
      return Preconditions.checkNotNull(instance.providerTiger(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
```
5. `Playground_MembersInjector.injectTiger(instance, zooComponent.providerTiger())`
为`Playground`对象中所需字段赋值,`instance`为`Playground`对象,`zooComponent.providerTiger()`上面分析过是用来创建tiger对象的。
```java
public final class Playground_MembersInjector implements MembersInjector<Playground> {
    public static void injectTiger(Playground instance, Object tiger) {
      // 最终的赋值操作在这里
      instance.tiger = (Tiger) tiger;
    }
}
```
注射器之间的依赖唯一要注意的点是被依赖的注射器需要定义接口方法将自己需要提供的对象暴露给需要的注射器,案例中提供了`Tiger providerTiger()`接口方法用来暴露`Tiger`对象.