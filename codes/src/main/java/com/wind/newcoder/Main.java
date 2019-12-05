package com.wind.newcoder;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);

			while (sc.hasNext()) {
				int left = sc.nextInt();
				int right = sc.nextInt();

				System.out.println(lcm(left, right));
			}
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	private static int lcm(int left, int right) {
		int gcd = gcd(left, right);
		return left * right / gcd;
	}

	private static int gcd(int left, int right) {
		if (left < right) {
			return gcd(right, left);
		}
		if (right == 0) {
			return left;
		}
		left = left % right;
		return gcd(right, left);
	}
}