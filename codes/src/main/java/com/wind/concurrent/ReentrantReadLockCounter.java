package com.wind.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadLockCounter implements Counter {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private long value = 0L;
    @Override
    public void inc(String key) {
        lock.writeLock().lock();
        try {
            value ++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public long get(String key) {
        lock.readLock().lock();
        try {
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public long sum() {
        return get(null);
    }
}
