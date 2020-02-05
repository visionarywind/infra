package com.wind.leetcode.dp;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class DecodeWaysTest {
    @Tested
    private DecodeWays impl;

    /*
    1 -> 1

    12 ->   1 2,
            12

    122 ->  1 2 2,
            12 2,
            1 22


    1221 -> 1 2 2 1,
            1 2 21,
            12 2 1,
            12 21
            1 22 1,

    12211 ->    1 2 2 1 1,
                12 2 1 1,
                12 21 1,
                12 2 11,
                1 22 1 1,
                1 22 11,
                1 2 21 1,
                1 2 2 11

    * */
    @Test
    public void testDecode() {
        String[] inputs = { "101", "0", "10", "110", "1010", "100", "1", "12", "123", "122", "1231", "1221", "12211" };
        int[] expects = { 1, 0, 1, 1, 1, 0, 1, 2, 3, 3, 3, 5, 8 };
        for (int i=0; i!=inputs.length; i++) {
            Assert.assertEquals(expects[i], impl.decode(inputs[i]));
        }
    }
}
