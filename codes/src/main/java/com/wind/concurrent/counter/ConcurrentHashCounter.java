package com.wind.concurrent.counter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentHashCounter implements Counter {
    private ConcurrentHashMap<String, LongAdder> store = new ConcurrentHashMap<>();

    @Override
    public void inc(String key) {
        LongAdder calculator = store.compute(key, (k, old) -> old == null ? new LongAdder() : old);
        calculator.add(1);
    }

    @Override
    public long get(String key) {
        LongAdder calculator = store.get(key);
        if (calculator == null) { return -1L; }
        return calculator.sum();
    }

    @Override
    public long sum() {
        return store.values().stream().map(LongAdder::sum).reduce(0L, Long::sum);
    }
}
