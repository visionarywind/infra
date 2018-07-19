package com.wind.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shanfeng on 2018/7/19.
 */
public class FindMinimumInRotatedSortedArrayTest {
    @Test
    public void testFindMin() {
        int[] array1 = new int[] {0, 1, 2, 3};
        int[] array2 = new int[] {4, 0, 2, 3};
        int[] array3 = new int[] {2, 3, 0, 1};
        int[] array4 = new int[] {1, 2, 3, 0};
        Assert.assertTrue(FindMinimumInRotatedSortedArray.findMin(array1) == 0);
        Assert.assertTrue(FindMinimumInRotatedSortedArray.findMin(array2) == 0);
        Assert.assertTrue(FindMinimumInRotatedSortedArray.findMin(array3) == 0);
        Assert.assertTrue(FindMinimumInRotatedSortedArray.findMin(array4) == 0);

    }
}
