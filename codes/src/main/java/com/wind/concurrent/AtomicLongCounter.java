package com.wind.concurrent;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongCounter implements Counter {
    private AtomicLong value = new AtomicLong(0);
    @Override
    public void inc(String key) {
        value.getAndIncrement();
    }

    @Override
    public long get(String key) {
        return value.get();
    }

    @Override
    public long sum() {
        return value.get();
    }
}
