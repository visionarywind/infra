package com.wind.mi;

/**
 * Created by shanfeng on 7/12/18.
 *
 描述
 和所有的 OJ 平台一样，第一题作为热身题，也是送分题：给出两个正整数 a 和 b，输出 a+b 的结果。

 输入
 一行数据包含两个正整数， a 和 b，空格分开。(a 和 b 保证小于 2^32)

 输出
 你的输出是对一行数据处理的结果，也即 a+b 的结果。

 输入样例
 1 2

 3 4

 5 6

 7 8

 9 10

 输出样例
 3

 7

 11

 15

 19
 *
 */
public class APlusB {
	public static String solution(String line) {
		// 在此处理单行数据
		String[] array = line.split(" ");
		int left = Integer.parseInt(array[0]);
		int right = Integer.parseInt(array[1]);
		long sum = left + right;

		// 返回处理后的结果
		return Long.toString(sum);
	}
}
