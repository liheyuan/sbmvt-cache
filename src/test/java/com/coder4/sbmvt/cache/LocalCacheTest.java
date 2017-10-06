/**
 * @(#)LocalCacheTest.java, Oct 06, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.coder4.sbmvt.cache;

import java.util.Arrays;

/**
 * @author coder4
 */
public class LocalCacheTest {

    private static void testLocalCache() throws InterruptedException {
        LocalCache<TestKey, TestValue> cache = new LocalCache<>(100, 1);

        TestKey key1 = new TestKey("key1");
        TestKey key2 = new TestKey("key2");
        TestKey key3 = new TestKey("key3");
        TestValue val1 = new TestValue("val1-1", "val1-2");
        TestValue val2 = new TestValue("val2-1", "val2-2");

        cache.put(key1, val1);
        cache.put(key2, val2);

        System.out.println(cache.get(key1));
        System.out.println(cache.get(key2));
        System.out.println(cache.get(key3));
        System.out.println(cache.batchGet(Arrays.asList(key1, key2, key3)));

        Thread.sleep(1050);

        System.out.println(cache.get(key1));
        System.out.println(cache.get(key2));
        System.out.println(cache.get(key3));
        System.out.println(cache.batchGet(Arrays.asList(key1, key2, key3)));

    }

    private static void testLocalCacheBM() throws InterruptedException {
        LocalCache<TestKey, TestValue> cache = new LocalCache<>(100, 0);

        TestKey key1 = new TestKey("key1");
        TestKey key2 = new TestKey("key2");
        TestKey key3 = new TestKey("key3");
        TestValue val1 = new TestValue("val1-1", "val1-2");
        TestValue val2 = new TestValue("val2-1", "val2-2");

        long start = System.currentTimeMillis();
        for (int i = 0; i<3000000; i++) {
            cache.put(key1, val1);
            cache.put(key2, val2);
            cache.batchGet(Arrays.asList(key1, key2, key3));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    public static void main(String [] args) throws InterruptedException {
        testLocalCache();
        testLocalCacheBM();
    }
}