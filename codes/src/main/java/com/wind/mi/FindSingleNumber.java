package com.wind.mi;

/**
 * Created by shanfeng on 7/12/18.
 *
 描述
 给出N个数字。其中仅有一个数字出现过一次，其他数字均出现过两次，找出这个出现且只出现过一次的数字。要求时间和空间复杂度最小。

 输入
 输入多个数字，每个数字以空格分开，回车结束

 输出
 输出内容为只出现过唯一一次的数字

 输入样例
 10 10 11 12 12 11 16

 输出样例
 16
 *
 */
public class FindSingleNumber {
	public static String solution(String line) {
		// 在此处理单行数据
		String[] array = line.split(" ");
		int xorSum = 0;
		for (int i=0; i!=array.length; i++) {
			xorSum ^= Integer.parseInt(array[i]);
		}
		// 返回处理后的结果
		return Integer.toString(xorSum);
	}
}
