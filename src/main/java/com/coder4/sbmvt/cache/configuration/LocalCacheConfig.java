/**
 * @(#)LocalCacheProperties.java, Oct 08, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.coder4.sbmvt.cache.configuration;

/**
 * @author coder4
 */
public class LocalCacheConfig {
    private int ttlSecs;
    private int capacity;

    public int getTtlSecs() {
        return ttlSecs;
    }

    public void setTtlSecs(int ttlSecs) {
        this.ttlSecs = ttlSecs;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}