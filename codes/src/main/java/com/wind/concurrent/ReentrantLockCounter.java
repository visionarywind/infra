package com.wind.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements Counter {
    private ReentrantLock lock = new ReentrantLock();
    private long value = 0L;
    @Override
    public void inc(String key) {
        lock.lock();
        try {
            value ++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public long get(String key) {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public long sum() {
        return value;
    }
}
