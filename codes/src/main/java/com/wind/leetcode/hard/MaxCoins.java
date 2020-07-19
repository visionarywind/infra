package com.wind.leetcode.hard;

public class MaxCoins {
    public int maxCoins(int[] nums) {
        return search(nums);
    }

    private int search(int[] nums) {
        int[] arr = new int[nums.length+2];
        arr[0] = arr[arr.length-1] = 1;
        System.arraycopy(nums, 0, arr, 1, nums.length);
        // return dfs(arr, 0, arr.length-1);

        int[][] dp = new int[arr.length][arr.length];
        for (int i=arr.length-1; i>=0; i--) {
            for (int j=i+2; j<arr.length; j++) {
                for (int k=i+1; k<j; k++) {
                    int sum = arr[i] * arr[k] * arr[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(sum, dp[i][j]);
                }

            }
        }
        return dp[0][arr.length-1];
    }



    private int dfs(int[] array, int left, int right) {
        if (left > right - 2) { return 0; }
        int max = Integer.MIN_VALUE;
        for (int i=left+1; i!=right; i++) {
            int sum = array[left] * array[i] * array[right];
            max = Math.max(sum + dfs(array, left, i) + dfs(array, i, right), max);
        }
        return max;
    }

    private int timeout(int[] nums) {
        return Double.valueOf(maxCoinsHelper(nums)).intValue();
    }

    private double maxCoinsHelper(int[] nums) {
        if (nums.length == 2) { return nums[0]*nums[1] + Math.max(nums[0], nums[1]); }
        if (nums.length == 1) { return nums[0]; }
        if (nums.length == 0) { return 0; }

        double max = Double.MIN_VALUE;
        for (int i=0; i!=nums.length; i++) {
            double cutting = maxCoinsHelper(cut(nums, i));
            max = Math.max(max, cutting + connected(nums, i));
        }
        return max;
    }

    private int[] cut(int[] array, int index) {
        int[] ret = new int[array.length - 1];
        if (index > 0) {
            System.arraycopy(array, 0, ret, 0, index);
        }
        if (array.length - index -1 > 0) {
            System.arraycopy(array, index + 1, ret, index, array.length - index - 1);
        }
        return ret;
    }

    private double connected(int[] array, int index) {
        if (index == 0) {
            return array[index] * array[index+1];
        } else if (index == array.length-1) {
            return array[index-1] * array[index];
        }
        return array[index-1] * array[index] * array[index+1];
    }
}
