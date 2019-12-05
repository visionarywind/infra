package com.wind.newcoder;

import java.util.Scanner;

public class PrimeFactor{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			long input = sc.nextLong();
			System.out.println(getResult(input));
		}
	}

	public static String getResult(long ulDataInput) {
		if (ulDataInput <= 3) {
			return "1 " + String.valueOf(ulDataInput) + " ";
		}
		long input = ulDataInput;
		long limit = (long)(Math.sqrt(input) + 1);
		int maxBits = (int)((limit / 16) + 1);
		char[] bits = new char[maxBits];
		StringBuffer sb = new StringBuffer();
		for (int i=2; i<=limit; i++) {
			int index = i >> 4;
			int offset = i & 0xff;
			if ((bits[index] & (1 << offset)) != 0) {
				continue;
			}

			while (input % i == 0 && input > 1) {
				sb.append(i).append(' ');
				input = input / i;
			}
			fill(bits, i, limit);
			limit = (long)(Math.sqrt(input) + 1);
		}

		if (input == ulDataInput) {
			sb.append("1 ");
		}
		if (input > 1) {
			return sb.append(input).append(' ').toString();
		}
		return sb.toString();
	}

	private static void fill(char[] bits, int start, long limit) {
		for (int i=1; start<=limit; start*=i, i++) {
			int index = start >> 4;
			int offset = start & 0xff;
			bits[index] |= (1 << offset);
		}
	}
}