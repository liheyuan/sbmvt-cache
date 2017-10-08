/**
 * @(#)MemcachedCacheBuilder.java, Oct 08, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.coder4.sbmvt.cache.builder;

import com.coder4.sbmvt.cache.CacheKeyTransformer;
import com.coder4.sbmvt.cache.CacheValueTransformer;
import com.coder4.sbmvt.cache.MemcachedCache;
import com.coder4.sbmvt.cache.configuration.MemcachedCacheConfig;

import javax.annotation.Nonnull;

/**
 * @author coder4
 */
public class MemcachedCacheBuilder<K, V> {

    public MemcachedCache<K, V> createCache(@Nonnull MemcachedCacheConfig config,
                                            CacheKeyTransformer<K> keyTransformer,
                                            CacheValueTransformer<V> valueTransformer) throws Exception {
        if (config == null) {
            throw new RuntimeException("LocalCacheConfig is null");
        }

        MemcachedCache<K, V> memcachedCache = new MemcachedCache<>(
                config.getServerList(),
                config.getTtlSecs(),
                keyTransformer,
                valueTransformer);

        memcachedCache.init();

        return memcachedCache;
    }
}