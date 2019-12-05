package com.wind.newcoder;

import java.util.Scanner;

public class ReverseDistinct{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int count = sc.nextInt();
			System.out.println(reverseDistinct(count));
		}
	}

	private static int reverseDistinct(int src) {
		String str = String.valueOf(src);
		int[] dup = new int[10];
		int ret = 0;
		for (int i=str.length()-1; i!=-1; i--) {
			int cur = str.charAt(i) - '0';
			if (dup[cur] == 0) {
				ret = ret * 10 + cur;
			}
			dup[cur] = 1;
		}
		return ret;
	}
}