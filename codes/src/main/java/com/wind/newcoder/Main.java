package com.wind.newcoder;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			while (sc.hasNext()) {
				String input = sc.nextLine();
				System.out.println(format(input));
			}
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	// 将输入拆分为数字模式数组和英文模式数组
	// 然后合并结果进行输出
	private static String format(String src) {
		String[] arr = src.split("#");
		StringBuilder sb = new StringBuilder();
		for (int i=0, j=1; i<arr.length || j<arr.length; i+=2, j+=2) {
			sb.append(digitFormat(arr[i]));
			if (j < arr.length) {
				sb.append(englishFormat(arr[j]));
			}
		}
		return sb.toString();
	}

	private static String digitFormat(String src) {
		if (src != null && src.length() > 0 && src.charAt(0) == '/') {
			return src.substring(1);
		}
		return src;
	}

	private static String englishFormat(String src) {
		StringBuilder sb = new StringBuilder();
		for (int i=0, end=src.length(); i!=end; i++) {
			char ch = src.charAt(i);
			if (ch == '/') {
				continue;
			}
			int count = preFetch(src, i, ch);
			sb.append(dictQuery(ch, count));
			i += count;
		}
		return sb.toString();
	}

	private static int preFetch(String src, int start, char target) {
		int count = 0;
		for (int i=start+1, end=src.length()-1; i<=end; i++) {
			if (target == src.charAt(i)) {
				count ++;
			} else {
				break;
			}
		}
		return count;
	}

	static char[][] dict = { { ' ' }, { ',', '.' }, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	private static char dictQuery(char ch, int count) {
		int index = ch - '0';
		int pos = count % dict[index].length;
		return dict[index][pos];
	}
}