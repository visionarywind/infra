package com.wind.concurrent;

public class SampleCounter implements Counter {
    private long value = 0L;

    public synchronized void inc(String key) {
        value ++;
    }

    public synchronized long get(String key) {
        return value;
    }

    public synchronized long sum() { return value; }
}
