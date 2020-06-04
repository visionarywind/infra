package com.wind.concurrent.counter;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class VolatileCounter implements Counter {
    private static Unsafe magic = null;
    private static long offset = 0L;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            magic = (Unsafe) field.get(null);
            offset = magic.objectFieldOffset(VolatileCounter.class.getDeclaredField("num"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private volatile long num;  // no purpose way

    @Override
    public void inc(String key) {
        magic.getAndAddLong(this, offset, 1L);
    }

    @Override
    public long get(String key) {
        return num;
    }

    @Override
    public long sum() {
        return num;
    }
}
