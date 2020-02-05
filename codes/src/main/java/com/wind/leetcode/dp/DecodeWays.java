package com.wind.leetcode.dp;

/*
*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given a non-empty string containing only digits, determine the total number of ways to decode it.

    Example 1:

    Input: "12"
    Output: 2
    Explanation: It could be decoded as "AB" (1 2) or "L" (12).
    Example 2:

    Input: "226"
    Output: 3
    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
* */
public class DecodeWays {
    /**
     * f[i] : 第i位构成的数目
     *
     * f[i+1] = {
     *     f[i]，当[i, i+1]不能构成组合
     *     f[i-1] + f[i]，当[i, i+1]能够构成组合
     * }
     * */
    public int decode(String msg) {
        if (msg == null || msg.length() == 0) { return 0; }
        if (msg.length() == 1 && msg.charAt(0) == '0') { return 0; }
        int[] dp = new int[msg.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=1, end=msg.length(); i!=end; i++) {
            boolean isZero = msg.charAt(i) == '0';
            if (isZero && msg.charAt(i-1) == '0') { return 0; }
            if (msg.charAt(i-1) - '0' > 0 && msg.charAt(i-1) - '0' < 3 && msg.charAt(i) - '0' < 7) {
                dp[i+1] = dp[i-1] + (isZero ? 0 : dp[i]);
            } else {
                dp[i+1] = dp[i];
            }
        }
        return dp[msg.length()];
    }

}
