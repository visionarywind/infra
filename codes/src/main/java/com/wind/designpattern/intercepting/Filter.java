package com.wind.designpattern.intercepting;

public interface Filter<T, R> {
    R execute(T t);

    void setNext(Filter<T, R> filter);

    Filter<T, R> getNext();
    Filter<T, R> getLast();
}
