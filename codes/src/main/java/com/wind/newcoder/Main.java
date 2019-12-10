package com.wind.newcoder;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			while (sc.hasNext()) {
				String input = sc.nextLine();
				System.out.println(input);
			}
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return true;
		}
		boolean[][] dp = new boolean[s.length()][t.length()];
		for (int i=0; i!=s.length(); i++) {
			if (s.charAt(i) == t.charAt(0)) {
				dp[i][0] = true;
			}
		}
		for (int j=0; j!=t.length(); j++) {
			if (t.charAt(j) == s.charAt(0)) {
				dp[0][j] = true;
			}
		}
		for (int i=1; i!=s.length(); i++) {
			for (int j=1; j!=t.length(); j++) {
				if (s.charAt(i) == t.charAt(j)) {
					dp[i][j] = dp[i][j];
				} else {
					dp[i][j] = dp[i][j-1] | dp[i-1][j];
				}
			}
		}
		return dp[s.length()-1][t.length()-1];
	}
}