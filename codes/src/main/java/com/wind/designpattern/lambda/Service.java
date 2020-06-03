package com.wind.designpattern.lambda;

@FunctionalInterface
public interface Service<T, R> {
    R apply(T t);
}
