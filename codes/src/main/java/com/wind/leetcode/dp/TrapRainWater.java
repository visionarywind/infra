package com.wind.leetcode.dp;

import java.util.Stack;

/*
* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class TrapRainWater {
	public static int trap(int[] height) {
		// use stack
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i=0, end=height.length; i!=end; i++) {
			while (!stack.empty() && height[i] >= height[stack.peek()]) {
				if (height[i] == height[stack.peek()]) {
					stack.pop();
					continue;
				}
				int h = height[stack.pop()]; //取出要出栈的元素
				if (stack.empty()) { // 栈空就出去
					break;
				}

				int distance = i - stack.peek() - 1; //两堵墙之前的距离。
				int min = Math.min(height[stack.peek()], height[i]);
				sum = sum + distance * (min - h);
			}
			stack.push(i); //当前指向的墙入栈
		}
		return sum;
	}
}
