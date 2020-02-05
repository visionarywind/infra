package com.wind.leetcode.array;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) { throw new IllegalArgumentException(); }

        return help(nums, 0, nums.length-1, --k);
    }

    private int help(int[] nums, int start, int end, int k) {
        int pos = partition(nums, start, end);
        if (pos == k) {
            return nums[pos];
        } else if (pos > k) {
            return help(nums, start, pos - 1, k);
        } else {
            return help(nums, pos + 1, end, k);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int key = nums[start];
        int index = start;
        for (int i=start+1; i<=end; i++) {
            if (nums[i] > key) {
                index ++;
                swap(nums, index, i);
            }
        }
        nums[start] = nums[index];
        nums[index] = key;
        return index;
    }

    private void swap(int[] nums, int left, int right) {
        if (left != right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }
}
