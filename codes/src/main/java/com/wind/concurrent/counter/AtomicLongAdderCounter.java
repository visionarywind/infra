package com.wind.concurrent.counter;

import java.util.concurrent.atomic.LongAdder;

public class AtomicLongAdderCounter implements Counter {
    private LongAdder value = new LongAdder();

    @Override
    public void inc(String key) {
        value.add(1);
    }

    @Override
    public long get(String key) {
        return value.sum();
    }

    @Override
    public long sum() {
        return value.sum();
    }
}
