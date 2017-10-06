/**
 * @(#)LRULocalCache.java, Oct 06, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.coder4.sbmvt.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author coder4
 */
public class LocalCache<K, V > implements ICache<K, V> {

    private Cache<K, V> gCache;

    public LocalCache(long capacity, long ttlSecs) {

        CacheBuilder builder = CacheBuilder.newBuilder();
        if (capacity > 0) {
            builder.maximumSize(capacity);
        }
        if(ttlSecs > 0) {
            builder.expireAfterWrite(ttlSecs, TimeUnit.SECONDS);
        }

        this.gCache =  builder.build();
    }

    @Nullable
    @Override
    public V get(K key) {
        return gCache.getIfPresent(key);
    }

    @Override
    public Map<K, V> batchGet(Collection<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return new HashMap<>();
        } else {
            Map<K, V> result = new HashMap<>();
            for (K key: keys) {
                V val = gCache.getIfPresent(key);
                if (val != null) {
                    result.put(key, val);
                }
            }
            return result;
        }
    }

    @Override
    public void put(K key, V value) {
        gCache.put(key, value);
    }
}