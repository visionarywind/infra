package com.wind.mi;

import java.util.HashSet;

/**
 * Created by shanfeng on 7/12/18.
 *
 描述
 输入一个乱序的连续数列，输出其中最长连续数列长度，要求算法复杂度为  O(n)  。

 输入
 54,55,300,12,56

 输出
 3

 输入样例
 100,4,200,1,3,2

 54,55,300,12

 1

 5,4,3,2,1

 1,2,3,4,5,6

 输出样例
 4

 2

 1

 5

 6
 *
 */
public class LongestContinuousSeries {
	public static String solution(String line) {
		// 在此处理单行数据
		String[] array = line.split(",");
		HashSet<Integer> set = new HashSet<Integer>(array.length);
		for (int i=0; i!=array.length; i++) {
			set.add(Integer.parseInt(array[i]));
		}
		int maxCount = 0;
		while (!set.isEmpty()) {
			Integer e = set.iterator().next();
			set.remove(e);
			int count = 1;
			int up = e;
			while (!set.isEmpty()) {
				up += 1;
				if (set.contains(up)) {
					count ++;
					set.remove(up);
				} else {
					break;
				}
			}
			int down = e;
			while (!set.isEmpty()) {
				down -= 1;
				if (set.contains(down)) {
					count ++;
					set.remove(down);
				} else {
					break;
				}
			}
			maxCount = maxCount > count ? maxCount : count;
		}
		// 返回处理后的结果
		return Integer.toString(maxCount);
	}
}
