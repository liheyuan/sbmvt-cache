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

    static class TestKey {
        private String key;

        public TestKey() {

        }

        public TestKey(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return key;
        }
    }

    static class TestValue {
        private String val1;
        private String val2;

        public TestValue() {

        }

        public TestValue(String val1, String val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        public String getVal1() {
            return val1;
        }

        public void setVal1(String val1) {
            this.val1 = val1;
        }

        public String getVal2() {
            return val2;
        }

        public void setVal2(String val2) {
            this.val2 = val2;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("TestValue{");
            sb.append("val1='").append(val1).append('\'');
            sb.append(", val2='").append(val2).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    static class TestValueTransformer extends JsonCacheValueTransformer<TestValue> {

        public TestValueTransformer() {
            super(TestValue.class);
        }
    }

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