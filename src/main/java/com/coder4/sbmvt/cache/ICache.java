/**
 * @(#)ICache.java, Oct 06, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.coder4.sbmvt.cache;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author coder4
 */
public interface ICache<K, V> {

    /**
     * Single get
     * @param key
     * @return
     */
    @Nullable
    V get(K key);

    /**
     * Batch get
     * @param keys
     * @return
     */
    Map<K, V> batchGet(Collection<K> keys);

    /**
     * Single put
     * @param key
     * @param value
     */
    void put(K key, V value);



}