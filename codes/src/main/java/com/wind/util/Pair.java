package com.wind.util;

import lombok.Data;

@Data
public class Pair<K, V> {
    private final K key;
    private final V value;

    public K getKey() { return key; }
    public V getValue() { return value; }

    private Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static<K, V> Pair<K, V> valueOf(K key, V value) {
        return new Pair<>(key, value);
    }
}
