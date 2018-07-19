package com.wind.leetcode.array;

/**
 * Created by shanfeng on 2018/7/19.
 *
 */
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        return doFindMin(array, 0, array.length-1);
    }

    private static int doFindMin(int[] array, int start, int end) {
        if (start == end) { return array[start]; }
        if (start + 1 == end) { return Math.min(array[start], array[end]); }

        int mid = start + (end - start)/2;
        if (array[mid] < array[start]) {
            return doFindMin(array, start+1, mid);
        } else {
            if (array[start] < array[end]) {
                return array[start];
            } else {
                return doFindMin(array, mid+1, end);
            }
        }
    }
}
