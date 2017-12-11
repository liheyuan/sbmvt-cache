/**
 * @(#)TestValueTransformer.java, Oct 06, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.coder4.sbmvt.cache;

/**
 * @author coder4
 */
public class TestValueTransformer extends JsonCacheValueTransformer<TestValue> {

    public TestValueTransformer() {
        super(TestValue.class);
    }
}