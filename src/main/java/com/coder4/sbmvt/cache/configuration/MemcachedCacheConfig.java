/**
 * @(#)MemcachedCacheConfig.java, Oct 08, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.coder4.sbmvt.cache.configuration;

/**
 * @author coder4
 */
public class MemcachedCacheConfig {
    private String serverList;
    private int ttlSecs = 0;

    public String getServerList() {
        return serverList;
    }

    public void setServerList(String serverList) {
        this.serverList = serverList;
    }

    public int getTtlSecs() {
        return ttlSecs;
    }

    public void setTtlSecs(int ttlSecs) {
        this.ttlSecs = ttlSecs;
    }
}