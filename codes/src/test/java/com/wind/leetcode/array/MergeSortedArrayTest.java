package com.wind.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shanfeng on 2018/7/19.
 */
public class MergeSortedArrayTest {
    @Test
    public void testMerge() {
        int[] A = new int[10];
        for (int i=0; i<8; i++) {
            A[i] = i*2;
        }
        int[] B = new int[] { 8, 30 };
        int[] expected = new int[] { 0, 2, 4, 6, 8, 8, 10, 12, 14, 30 };
        MergeSortedArray.merge(A, 8, B, 2);
        Assert.assertArrayEquals(expected, A);
    }
}
