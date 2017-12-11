/**
 * @(#)LocalCacheBuilder.java, Oct 08, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.coder4.sbmvt.cache.builder;

import com.coder4.sbmvt.cache.LocalCache;
import com.coder4.sbmvt.cache.configuration.LocalCacheConfig;

import javax.annotation.Nonnull;

/**
 * @author coder4
 */
public class LocalCacheBuilder<K, V> {

    public LocalCache<K, V> createCache(@Nonnull LocalCacheConfig config) {
        if (config == null) {
            throw new RuntimeException("LocalCacheConfig is null");
        }

        return new LocalCache<>(config.getCapacity(), config.getTtlSecs());
    }
}