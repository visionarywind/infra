package com.wind.leetcode.dp;

/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
* */
public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for (int i=0; i<=s.length(); i++) {
            for (int j=1; j<=p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = (j>1 && dp[i][j-2]);
                    if (match(s, i, p, j-1)) {
                        dp[i][j] |= dp[i-1][j];
                    }
                } else {
                    if (match(s, i, p, j)) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private static boolean match(String s, int left, String p, int right) {
        if (left == 0) { return false; }
        if (p.charAt(right-1) == '.') { return true; }
        return s.charAt(left-1) == p.charAt(right-1);
    }
}
