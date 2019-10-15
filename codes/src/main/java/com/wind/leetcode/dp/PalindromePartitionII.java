package com.wind.leetcode.dp;

/*
* Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
* */

public class PalindromePartitionII {
	public static int minCut(String s) {
		if (s.length() <= 1) {
			return 0;
		}

		int len = s.length();
		int[] minDp = new int[len];
		for (int i=0; i!=len; i++) {
			minDp[i] = i;
		}
		boolean[][] dp = new boolean[len][len];
		for (int i=1; i<len; i++) {
			for (int j=i; j>=0; j--) {
				if (s.charAt(i) == s.charAt(j) && (i-j<2 || dp[j+1][i-1])) {
					dp[j][i] = true;
					int prevCut = (j-1>=0) ? minDp[j-1] : -1;
					minDp[i] = Math.min(minDp[i], prevCut + 1);
				}
			}
		}
		return minDp[len-1];
	}
}
