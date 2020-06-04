package com.wind.concurrent.counter;

public interface Counter {
    void inc(String key);
    long get(String key);
    long sum();
}
