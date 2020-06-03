package com.wind.designpattern.intercepting;

public class SampleFilter<T> extends AbstractFilter<T, T> {
    @Override
    public T execute(T t) {
        if (getNext() != null) { return getNext().execute(t); } else { return t; }
    }
}
