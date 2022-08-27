package com.yeyu.base.泛型;


public class 泛型方法 {
    public <T> T getObject(T c) {
       return c;
    }
    public <T> T getObject2(Class<T> c) throws IllegalAccessException, InstantiationException {
        return c.newInstance();
    }
}
