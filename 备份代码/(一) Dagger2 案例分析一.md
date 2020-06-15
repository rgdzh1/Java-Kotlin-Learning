##### 代码示例
```java
// 对象提供方
class Tiger {
    // @Inject:该注解用于类构造方法上表示该类可以被Dagger2实例化对象后供注射器使用.
    @Inject  
    public Tiger() {
    }
    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}
// 对象使用者
public class Zoo {
    // @Inject: 该注解用于成员变量上代表注射器可以为该成员变量赋值对象.
    @Inject
    Tiger tiger;

    @Test
    public void 案例一() {
        DaggerZooComponent.create().inject(this);
        tiger.sleep();
    }
}
// 注射器
// @Component: 该注解是用来创造对象提供方和对象使用间的桥梁,如何将对象赋值给成员变量都是由它来做的.
@Component
interface ZooComponent {
    Zoo inject(Zoo zoo);
}
```
##### Dagger2生成代码阅读
> 主要说的是`@Inject`注解提供对象给注射器使用.
就着上面的案例来看下Degger2生成的代码,生成的代码在`build\generated\sources\annotationProcessor\..`文件夹中.
1. `DaggerZooComponent.create()`
`create()`用来生成`DaggerZooComponent`对象,`DaggerZooComponent`的父类是`ZooComponent`接口,它重写了接口中的`inject()`方法.
```java
final class DaggerZooComponent implements ZooComponent {
    // create()方法创建DaggerZooComponent()对象
    public static ZooComponent create() {
      return new Builder().build();
    }
    static final class Builder {
      private Builder() {
      }
      public ZooComponent build() {
        // build()方法返回DaggerZooComponent对象.
        return new DaggerZooComponent();
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
      // 接着调用了 Zoo_MembersInjector.injectTiger(instance, new Tiger());
      // new Tiger(): 这个对象就是由Dagger2创建的Tiger对象.
      // instance: 代表Zoo对象.
      Zoo_MembersInjector.injectTiger(instance, new Tiger());
      return instance;
    }
}
```
3. `Zoo_MembersInjector.injectTiger(instance, new Tiger())`
最终的赋值动作就是由`injectTiger()`方法做的.
```java
public final class Zoo_MembersInjector implements MembersInjector<Zoo> {
    @InjectedFieldSignature("com.yey.dagger2.Zoo.tiger")
    public static void injectTiger(Zoo instance, Object tiger) {
      // instance.tiger: 为Zoo中字段tiger
      // tiger: 为上一步方法DaggerZooComponent.injectZoo()创建的Tigerd对象.
      instance.tiger = (Tiger) tiger;
    }
}
```
通过一个非常简单的案例来熟悉Dagger2到底为各个对象做了些什么,下面会将案例复杂化.