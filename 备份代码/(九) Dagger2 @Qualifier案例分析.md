##### 代码示例
```java
class Tiger {
    String name;
    public Tiger(String name) {
        this.name = name;
    }
    public Tiger() {
    }
    public void sleep() {
        System.out.println("Tiger sleeping");
    }
}
// 自定义Qualifier注解
@Qualifier
public @interface Tiger1 {
}
// 自定义Qualifier注解
@Qualifier
public @interface Tiger2 {
}
@Module
class ZooModule {
    // 使用自定义Qualifier注解
    @Tiger1
    @Provides
    public Tiger providerTiger_1() {
        return new Tiger();
    }
    @Tiger2
    @Provides
    public Tiger providerTiger_2() {
        return new Tiger("米饭");
    }
}
@Component(modules = {ZooModule.class})
interface ZooComponent {
    Zoo inject(Zoo zoo);
}
public class Zoo {
    // 使用自定义Qualifier注解,用以区分tiger1到底使用注射器中的哪个对象.
    @Tiger1
    @Inject
    Tiger tiger1;
    @Tiger2
    @Inject
    Tiger tiger2;

    @Test
    public void 案例九() {
        DaggerZooComponent.create().inject(this);
        tiger1.sleep();
        tiger2.sleep();
    }
}
```
##### Dagger2生成代码阅读
> 主要分析当同一个注射器中存在两个相同类型的对象,容器中需要使用这两个对象的时候该如何区分.

就着上面的案例来看下Degger2生成的代码,生成的代码在`build\generated\sources\annotationProcessor\..`文件夹中.
- 当调用`.inject(this)`时,最终调用的代码如下:
```java
final class DaggerZooComponent implements ZooComponent {
   @Override
    public Zoo inject(Zoo zoo) {
        return injectZoo(zoo);
    }
   private Zoo injectZoo(Zoo instance) {
        // ZooModule_ProviderTiger_1Factory.providerTiger_1(zooModule): 通过ZooModule中的providerTiger_1()方法获取tiager对象
        // ZooModule_ProviderTiger_2Factory.providerTiger_2(zooModule): 通过ZooModule中的providerTiger_2()方法获取tiager对象
        Zoo_MembersInjector.injectTiger1(instance, ZooModule_ProviderTiger_1Factory.providerTiger_1(zooModule));
        Zoo_MembersInjector.injectTiger2(instance, ZooModule_ProviderTiger_2Factory.providerTiger_2(zooModule));
        return instance;
   } 
}
```
上面的很常规的代码,唯一的区别在于为容器中字段赋值`tiger`对象时,分别调用了两个不同的方法
```java
public final class Zoo_MembersInjector implements MembersInjector<Zoo> {
    @InjectedFieldSignature("com.yey.dagger2.Zoo.tiger1")
    @Tiger1 // 这是案例中定义的注解
    public static void injectTiger1(Zoo instance, Object tiger1) {
      instance.tiger1 = (Tiger) tiger1;// 容器中tiger1字段赋值为providerTiger_1()返回的对象
    }
    @InjectedFieldSignature("com.yey.dagger2.Zoo.tiger2")
    @Tiger2
    public static void injectTiger2(Zoo instance, Object tiger2) {
      instance.tiger2 = (Tiger) tiger2;// 容器中tiger2字段赋值为providerTiger_2()返回的对象
    }
}
```
当注射器中存在多个相同类型对象时候,自定义`@Qualifier`注解能够帮助容器获取特定的对象,另外如果注射器中存在多个相同类型的对象,Dagger2会报错重复绑定.