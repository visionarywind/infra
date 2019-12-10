package com.wind.leetcode.dp;

/*

Longest Valid Parentheses

Share
Given a string containing just the characters '(' and ')',
find the length of the longest valid (well-formed) parentheses substring.

Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

* */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int[] dp = new int[s.length()];
		int max = Integer.MIN_VALUE;
		for (int i=1; i!=s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == ')') {
				if (s.charAt(i-1) == '(') {
					dp[i] = i>1 ? dp[i-2] + 2 : 2;
				} else {
					int lastPos = i - dp[i-1] - 1;
					if (lastPos >=0 && s.charAt(lastPos) == '(') {
						dp[i] = dp[i-1] + 2 + (lastPos >= 1 ? dp[lastPos - 1] : 0);
					}
				}
				if (dp[i] > max) {
					max = dp[i];
				}
			}
		}

		return max;
	}
}
