package org.example.cache;

import java.util.LinkedHashMap;

public class CacheImpl<K, V> implements Cache<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> map = new LinkedHashMap<>();

    public CacheImpl(int capacity) {
        this.capacity = Math.max(capacity, 1);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public void put(K key, V value) {
        if (map.size() == capacity) {
            var firstEntry = map.entrySet().stream().findFirst().get();
            map.remove(firstEntry.getKey());
        }
        map.put(key, value);
    }

    @Override
    public V remove(K key) {
        return map.remove(key);
    }
}
