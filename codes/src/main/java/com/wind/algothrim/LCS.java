package com.wind.algothrim;

public class LCS {
    public static int lcs(String left, String right) {
        int[][] dp = new int[left.length()+1][right.length()+1];
        for (int i=0; i<=left.length(); i++) {
            for (int j=0; j<=right.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (left.charAt(i) == right.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[left.length()][right.length()];
    }
}
