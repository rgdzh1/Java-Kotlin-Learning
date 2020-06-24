package com.yey.dagger2;

// 顶层接口定义一些共有的方法
interface IBaseP {
}

interface IBaseV<T> {
    // 为V层创建P层对象
    // 泛型T确定了P层对象的类型
    T setPresenter(T t);
}

// 次级接口定义自己特有的方法
interface IMy {
    // <MyP>: 确定P层对象的类型为MyP
    interface MyV extends IBaseV<MyP> {
        void refreshPage();// 更新UI
    }

    interface MyP extends IBaseP {
        void getData();// 获取数据
    }
}
// P层的实现
// <T extends IMy.MyV>: 确定P层持有的V层类型
class MyPresenter<T extends IMy.MyV> implements IMy.MyP {
    T mView;

    public MyPresenter(T mView) {
        this.mView = mView;
    }

    @Override
    public void getData() {
        System.out.println("获取数据");
        mView.refreshPage();// 获取数据之后更新界面
    }
}
// 定义BaseActivity,<T>用来确定P层对象的类型.
abstract class BaseActivity<T> implements IBaseV<T> {
    T mPresenter;

    public BaseActivity() {
        // 调用子类实现的setPresenter()方法,创建P层对象,由父类mPresenter变量保存.
        mPresenter = setPresenter(mPresenter);
    }
}
// V层实现类
// <IMy.MyP>: 确定P层对象类型.
class MyActivity extends BaseActivity<IMy.MyP> implements IMy.MyV {
    public MyActivity() {
        mPresenter.getData();
    }

    @Override
    public void refreshPage() {
        System.out.println("更新界面");
    }
    // IBaseV.setPresenter()接口方法的具体实现.
    @Override
    public IMy.MyP setPresenter(IMy.MyP myP) {
        // <IMy.MyV>: 用来确认P层中V对象的类型.
        return new MyPresenter<IMy.MyV>(this);
    }
}

public class MVP {
    public static void main(String[] args) {
        new MyActivity();
    }
}
