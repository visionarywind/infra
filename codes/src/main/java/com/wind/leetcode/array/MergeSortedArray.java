package com.wind.leetcode.array;

/**
 * Created by shanfeng on 2018/7/19.
 */
public class MergeSortedArray {
    public static void merge(int[] A, int m, int[] B, int n) {
        int end = m + n - 1;
        m --;
        n --;
        for (int i=end; i!=-1; i--) {
            if (m >= 0 && n >= 0) {
                if (A[m] < B[n]) {
                    A[i] = B[n];
                    n --;
                } else {
                    A[i] = A[m];
                    m --;
                }
            } else if (m >= 0) {
                break;
            } else {
                A[i] = B[n];
                n --;
            }
        }
    }
}
