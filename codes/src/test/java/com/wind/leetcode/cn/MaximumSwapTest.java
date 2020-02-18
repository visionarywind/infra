package com.wind.leetcode.cn;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class MaximumSwapTest {
    @Tested
    private MaximumSwap impl;

    @Test
    public void testMaximumSwap() {
        Assert.assertEquals(7236, impl.maximumSwap(2736));
        Assert.assertEquals(7236, impl.maximumSwap2(2736));
        Assert.assertEquals(7236, impl.maximum(2736));
        Assert.assertEquals(20, impl.maximum(20));
        Assert.assertEquals(2000, impl.maximum(2000));
        Assert.assertEquals(200000, impl.maximum(200000));
        Assert.assertEquals(210000, impl.maximum(120000));
        Assert.assertEquals(21000, impl.maximum(20001));
        Assert.assertEquals(98863, impl.maximum(98368));
        Assert.assertEquals(210, impl.maximum(201));
        Assert.assertEquals(200, impl.maximum(200));

        Assert.assertEquals(7763, impl.maximumSwap(7736));
        Assert.assertEquals(7763, impl.maximumSwap2(7736));
        Assert.assertEquals(7763, impl.maximum(7736));

        Assert.assertEquals(7763, impl.maximumSwap(7367));
        Assert.assertEquals(7763, impl.maximumSwap2(7367));

        Assert.assertEquals(9973, impl.maximumSwap(9973));
        Assert.assertEquals(9973, impl.maximumSwap2(9973));

        Assert.assertEquals(9913, impl.maximumSwap(1993));
        Assert.assertEquals(9913, impl.maximumSwap2(1993));
        Assert.assertEquals(9913, impl.max(1993));
    }
}
