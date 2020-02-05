package com.wind.leetcode.dp;

public class Interleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) { return false; }

        if (s1.equals("")) { return s2.equals(s3); }
        else if (s2.equals("")) { return s1.equals(s3); }

        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for (int i=0; i!=len2; i++) { dp[0][i+1] = dp[0][i] && (s2.charAt(i) == s3.charAt(i)); }

        for (int i=0; i!=len1; i++) {
            dp[i+1][0] = dp[i][0] && (s1.charAt(i) == s3.charAt(i));
            for (int j=0; j!=len2; j++) {
                dp[i+1][j+1] = (dp[i][j+1] && s1.charAt(i) == s3.charAt(i + j + 1))
                    || (dp[i+1][j] && s2.charAt(j) == s3.charAt(i + j + 1));
            }
        }
        return dp[len1][len2];
    }
}
