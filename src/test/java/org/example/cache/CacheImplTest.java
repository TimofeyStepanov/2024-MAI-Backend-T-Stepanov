package org.example.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CacheImplTest {
    @Test
    void testFromExample() {
        Cache<String, String> cache = new CacheImpl<>(100);
        cache.put("Jesse", "Pinkman");
        cache.put("Walter", "White");
        cache.put("Jesse", "James");
        Assertions.assertEquals(cache.get("Jesse"), "James");
        cache.remove("Walter");
        Assertions.assertNull(cache.get("Walter"));
    }

    @Test
    void checkCacheAsMap() {
        Cache<String, String> cache = new CacheImpl<>(2);
        Assertions.assertNull(cache.remove("0"));

        cache.put("1", "1");
        cache.put("2", "2");

        Assertions.assertEquals(cache.get("1"), "1");
        Assertions.assertEquals(cache.get("2"), "2");

        Assertions.assertEquals(cache.remove("1"), "1");
        Assertions.assertNull(cache.remove("1"));
        Assertions.assertEquals(cache.get("2"), "2");
    }

    @Test
    void checkCachePush() {
        Cache<String, String> cache = new CacheImpl<>(2);
        cache.put("1", "1");
        cache.put("2", "2");

        // выталкивает 1
        cache.put("3", "3");
        Assertions.assertEquals(cache.get("3"), "3");
        Assertions.assertEquals(cache.get("2"), "2");
        Assertions.assertNull(cache.get("1"));
    }
}