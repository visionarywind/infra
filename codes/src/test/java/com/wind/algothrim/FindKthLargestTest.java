package com.wind.algothrim;

import com.wind.leetcode.array.FindKthLargest;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class FindKthLargestTest {
    @Tested
    private FindKthLargest impl;

    @Test
    public void testFindKthLargest() {
        int[] array = { 0, 1, 2, 3 };
        System.out.println(impl.findKthLargest(array, 4));
    }
}
