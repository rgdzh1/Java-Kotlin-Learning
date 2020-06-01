package com.yey.java.learning;

import org.junit.Test;

// 基类,封装了基本的操作
// 增删改查这些操作是必须要有的,目的都是相同的,封装一个基类.
class BaseDAO<T> {
    // 增
    public void add(T t) {

    }

    // 删
    public boolean delete(int index) {
        return false;
    }

    // 改
    public boolean update(int index, T t) {
        return false;
    }

    // 查
    public T getIndex(int index) {
        return null;
    }
}
class Customer{}
// 指定了父类泛型
class CustomerDAO extends BaseDAO<Customer>{
    // CustomerDAO 中封装对Customer表中特殊的操作,所以单独创建一个类出来
}

public class a05泛型使用场景 {
    @Test
    public void 泛型使用场景(){
        CustomerDAO customerDAO = new CustomerDAO();
        // 增加只能增加Customer类
        customerDAO.add(new Customer());
    }
}
