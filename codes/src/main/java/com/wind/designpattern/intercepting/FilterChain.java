package com.wind.designpattern.intercepting;

public class FilterChain<T, R> {
    private Filter<T, R> chain;

    public void addFilter(Filter<T, R> filter) {
        if ((null == chain)) { chain = filter; } else { chain.getLast().setNext(filter); }
    }


    public R execute(T t) {
        return chain != null ? chain.execute(t) : null;
    }
}
