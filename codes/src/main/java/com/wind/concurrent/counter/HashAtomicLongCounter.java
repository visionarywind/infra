package com.wind.concurrent.counter;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class HashAtomicLongCounter implements Counter {
    private AtomicLong[] store = {
        new AtomicLong(), new AtomicLong(), new AtomicLong(), new AtomicLong(),
        new AtomicLong(), new AtomicLong(), new AtomicLong(), new AtomicLong()
    };
    private int index = 0;

    @Override
    public void inc(String key) {
        store[index++ & 7].getAndAdd(1);
    }

    @Override
    public long get(String key) {
        return Arrays.stream(store).map(AtomicLong::get).reduce(0L, Long::sum);
    }

    @Override
    public long sum() {
        return Arrays.stream(store).map(AtomicLong::get).reduce(0L, Long::sum);
    }
}
