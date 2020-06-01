package com.wind.concurrent;

public class SynchronizedObjectCounter implements Counter {
    private Object lock = new Object();
    private long value = 0L;
    @Override
    public void inc(String key) {
        synchronized (lock) {
            value ++;
        }
    }

    @Override
    public long get(String key) {
        synchronized (lock) {
            return value;
        }
    }

    @Override
    public long sum() {
        return value;
    }
}
