package com.wind.concurrent.counter;

import java.util.concurrent.atomic.LongAdder;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuavaCacheCounter implements Counter {
    private LoadingCache<String, LongAdder> store = CacheBuilder
        .newBuilder()
        .build(new CacheLoader<String, LongAdder>() {
            @Override
            public LongAdder load(String key) {
                return new LongAdder();
            }
        });
    @Override
    public void inc(String key) {
        try {
            store.get(key).add(1L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public long get(String key) {
        try {
            return store.get(key).sum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1L;
    }

    @Override
    public long sum() {
        return store.asMap().values().stream().map(LongAdder::sum).reduce(0L, Long::sum);
    }
}
