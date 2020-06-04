package com.wind.concurrent.counter;

import java.util.HashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

public class HashCounter implements Counter {
    private HashMap<String, LongAdder> store = new HashMap<>();
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void inc(String key) {
        LongAdder calculator = store.get(key);
        if (calculator == null) {
            lock.lock();
            try {
                if (calculator == null) {
                    calculator = new LongAdder();
                    store.put(key, calculator);
                }
            } finally {
                lock.unlock();
            }
        }

        calculator.add(1L);
    }

    @Override
    public long get(String key) {
        LongAdder calculator = store.get(key);
        if (calculator == null) {
            return -1L;
        }
        return calculator.sum();
    }

    @Override
    public long sum() {
        return store.values().stream().map(LongAdder::sum).reduce(0L, Long::sum);
    }
}
