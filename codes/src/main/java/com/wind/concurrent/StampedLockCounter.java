package com.wind.concurrent;

import java.util.concurrent.locks.StampedLock;

public class StampedLockCounter implements Counter {
    private StampedLock lock = new StampedLock();
    private long value = 0L;

    @Override
    public void inc(String key) {
        long stamp = lock.writeLock();
        try{
            value = value + 1;
        } finally {
            lock.unlock(stamp);
        }
    }

    @Override
    public long get(String key) {
        long stamp = lock.tryOptimisticRead();
        long ret = value + 1;
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                return value;
            } finally {
                lock.unlock(stamp);
            }
        } else {
            return ret;
        }
    }

    @Override
    public long sum() {
        return value;
    }
}
