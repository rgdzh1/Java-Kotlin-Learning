##### 代码示例
```java
class Food {
    // @Inject:该注解用于类构造方法上表示该类可以被Dagger2实例化对象后供注射器使用.
    @Inject
    public Food() {
    }
}
class Tiger {
    // 假如老虎需要食物
    Food food;
    // @Inject:该注解用于类构造方法上表示该类可以被Dagger2实例化对象后供注射器使用.
    @Inject
    public Tiger(Food food) {
        this.food = food;
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
    public void 案例二() {
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
> 主要说将具有依赖关系的不同对象加入到注射器中,注射器会根据对象使用者的需求来自动处理这些依赖关系.
就着上面的案例来看下Degger2生成的代码,生成的代码在`build\generated\sources\annotationProcessor\..`文件夹中.
1. `DaggerZooComponent.create()`
`create()`用来生成`DaggerZooComponent`对象,`DaggerZooComponent`的父类是`ZooComponent`接口,它重写了接口中的`inject()`方法.
```java
final class DaggerZooComponent implements ZooComponent {
    private DaggerZooComponent() {
    }
    // create()方法创建DaggerZooComponent对象
    public static ZooComponent create() {
        return new Builder().build();
    }
    static final class Builder {
        private Builder() {
        }
        // 创建DaggerZooComponent对象
        public ZooComponent build() {
          return new DaggerZooComponent();
        }
    }                       
}
```
2. `.inject(this)`对象注入
使用`DaggerZooComponent`对象将注射器创建的`Tiger`对象注入到`Zoo`中.
```java
final class DaggerZooComponent implements ZooComponent {
    // 接口中的方法,由DaggerZooComponent实现,该方法就是用来向Zoo对象中注入Tiger对象的.
    @Override
    public Zoo inject(Zoo zoo) {
        // zoo就是inject(this)中的this了,代表Zoo对象.
        return injectZoo(zoo);
    }
    private Zoo injectZoo(Zoo instance) {
        // getTiger() 获取Tiger对象
        // instance: 就是.inject(this)中的this Zoo对象.
        Zoo_MembersInjector.injectTiger(instance, getTiger());
        return instance;
    }
    // Tiger与Food构造都标注了@Inject注解,他们之间存在依赖关系,这种依赖关系最终由注射器处理.
    private Tiger getTiger() {
      return new Tiger(new Food());
    }
}
```
3. `Zoo_MembersInjector.injectTiger(instance, getTiger());`
最终的赋值动作就是由`injectTiger()`方法做的.
```java
public final class Zoo_MembersInjector implements MembersInjector<Zoo> {
    @InjectedFieldSignature("com.yey.dagger2.Zoo.tiger")
    public static void injectTiger(Zoo instance, Object tiger) {
      // instance.tiger: 为Zoo中字段tiger
      // tiger: 为上一步方法DaggerZooComponent.getTiger()创建的Tigerd对象.
      instance.tiger = (Tiger) tiger;
    }
}
```