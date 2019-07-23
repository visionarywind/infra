package com.wind.leetcode.cn;

import java.util.Arrays;
import java.util.List;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.wind.leetcode.Utils;

@RunWith(JMockit.class)
public class TwoSumTest {
	@Tested
	private TwoSum impl;

	private List<Integer[]> inputArray;
	private List<Integer[]> outputArray;

	@Before
	public void setUp() {
		Integer[] arr1 = {9, 2, 7, 11, 15};
		Integer[] arr2 = {8, 4, 1, 4};
		Integer[] arr3 = {0, 4, 1, -4};
		Integer[] arr4 = {0, 4, -4};
		Integer[] arr5 = {2, 1, 1};
		inputArray = Utils.newArrayList(arr1, arr2, arr3, arr4, arr5);

		Integer[] ret1 = {0, 1};
		Integer[] ret2 = {0, 2};
		Integer[] ret3 = {0, 2};
		Integer[] ret4 = {0, 1};
		Integer[] ret5 = {0, 1};
		outputArray = Utils.newArrayList(ret1, ret2, ret3, ret4, ret5);
	}

	@Test
	public void testTwoSum() {
	    for (int i = 0; i != inputArray.size(); i ++) {
	        Integer[] input = inputArray.get(i);
	        int target = input[0];
	        Integer[] nums = Utils.subArray(input, 1, input.length);
            Assert.assertArrayEquals(outputArray.get(i), unprimitives(impl.twoSum(primitives(nums), target)));
        }
	}

	private int[] primitives(Integer[] src) {
	    int[] ret = new int[src.length];
	    for (int i = 0; i != src.length; i ++) {
	        ret[i] = src[i];
        }
        return ret;
    }

    private Integer[] unprimitives(int[] src) {
        Integer[] ret = new Integer[src.length];
        for (int i = 0; i != src.length; i ++) {
            ret[i] = src[i];
        }
        return ret;
    }
}
