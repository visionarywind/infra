package com.wind.newcoder;

import java.util.Scanner;
import java.util.HashMap;

public class Hex2Int{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			String input = sc.nextLine();
			String strLowerCase = input.startsWith("0x") ? input.substring(2).toLowerCase() : input.toLowerCase();
			System.out.println(parseLong(strLowerCase));
		}
	}

	private static long parseLong(String str){
		int len = str.length();
		long ret = 0;
		for (int i=len-1; i!=-1; i--) {
			long mid = hex2Int(str.charAt(i)) * hex2Base(len - i - 1);
			ret += mid;
		}
		return ret;
	}

	private static int hex2Int(char ch) {
		if (ch >= 'a') {
			return ch - 'a' + 10;
		}
		return ch - '0';
	}

	private static HashMap<Integer, Long> cache = new HashMap<>();
	private static long hex2Base(int bits) {
		Long val = cache.get(bits);
		if (null != val) {
			return val;
		}
		if (bits == 0) {
			cache.put(bits, 1L);
			return 1;
		}
		long ret = 16 * hex2Base(bits - 1);
		cache.put(bits, ret);
		return ret;
	}
}