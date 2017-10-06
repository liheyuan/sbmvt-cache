/**
 * @(#)MemcachedCacheTest.java, Oct 06, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.coder4.sbmvt.cache;

import java.util.Arrays;

/**
 * @author coder4
 */
public class MemcachedCacheTest {

    private static void testMemcachedCache() throws Exception {
        String serverList = "192.168.99.100:11211";
        MemcachedCache<TestKey, TestValue> memcachedCache = new MemcachedCache<>(
                serverList,
                0,
                new DefaultCacheKeyTransformer<>("testCache"),
                new TestValueTransformer());

        memcachedCache.init();

        TestKey key1 = new TestKey("key1");
        TestKey key2 = new TestKey("key2");
        TestKey key3 = new TestKey("key3");
        TestValue val1 = new TestValue("val1-1", "val1-2");
        TestValue val2 = new TestValue("val2-1", "val2-2");

        memcachedCache.put(key1, val1);
        memcachedCache.put(key2, val2);

        System.out.println(memcachedCache.get(key1));
        System.out.println(memcachedCache.get(key2));
        System.out.println(memcachedCache.get(key3));

        System.out.println(memcachedCache.batchGet(Arrays.asList(key1, key2, key3)));

    }

    public static void main(String [] args) throws Exception {
        testMemcachedCache();
    }

}