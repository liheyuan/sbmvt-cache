/**
 * @(#)DefaultJsonCacheKeyTransformer.java, Oct 06, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.coder4.sbmvt.cache;

/**
 * @author coder4
 */
public class DefaultCacheKeyTransformer<T> implements CacheKeyTransformer<T> {

    private String cacheType;

    public DefaultCacheKeyTransformer(String cacheType) {
        this.cacheType = cacheType;
    }

    @Override
    public String getKey(T t) {
        return cacheType + "#" + t.toString();
    }

}