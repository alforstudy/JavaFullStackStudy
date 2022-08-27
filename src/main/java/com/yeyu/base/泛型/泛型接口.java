package com.yeyu.base.泛型;

interface Info<T> {
    public T getVar();
}


class InfoImpl<T> implements Info<T> {

    @Override
    public T getVar() {
        return null;
    }
}

public class 泛型接口 {
}
