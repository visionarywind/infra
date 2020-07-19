package com.wind.leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

public class MaxCoinsTest {
    private MaxCoins impl = new MaxCoins();

    @Test
    public void testMaxCoins() {
        int[] array1 = { 3, 1, 5, 8 };
        Assert.assertEquals(167, impl.maxCoins(array1));
        int[] array2 = { 7,9,8,0,7,1,3,5,5,2,3,3 };
        Assert.assertEquals(1717, impl.maxCoins(array2));
    }
}
