package com.wind.algothrim;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by shanfeng on 2018/7/15.
 */
public class SortsTest {
    @Test
    public void testQuickSort() {
        int array[] = new int[] { 5, 4, 2, 1, 3 };
        int[] expectedArray = new int[] { 1, 2, 3, 4, 5 };
        Sorts.quickSort(array, 0, array.length-1);
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testHeapSort() {
        int[] array = new int[] { 5, 4, 2, 1, 3, 100, 20 };
        int[] expectedArray = new int[] { 5, 4, 2, 1, 3, 100, 20 };
        Sorts.heapSort(array, 0, array.length-1);
        Sorts.quickSort(expectedArray, 0, expectedArray.length-1);
        Assert.assertArrayEquals(array, expectedArray);
    }
}
