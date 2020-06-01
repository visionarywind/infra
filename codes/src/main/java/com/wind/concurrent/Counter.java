package com.wind.concurrent;

public interface Counter {
    void inc(String key);
    long get(String key);
    long sum();
}
