package com.wind.leetcode.order;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(JMockit.class)
public class LexicalOrderTest {
    @Tested
    private LexicalOrder impl;

    @Test
    public void testLexicalOrder() {
        int[] arr = { 13, 14 };
        Integer[][] expected = {
            {1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 10, 11, 12, 13, 14, 2, 3, 4, 5, 6, 7, 8, 9}
        };

        for (int i=0, end=arr.length; i!=end; i++) {
            Integer[] tmp = new Integer[expected[i].length];
            impl.lexicalOrder(arr[i]).toArray(tmp);
            Assert.assertArrayEquals(expected[i], tmp);
        }
    }
}
