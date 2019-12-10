package com.wind.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestValidParenthesesTest {
	@Test
	public void testLongestValidParenthesesTest() {
		LongestValidParentheses impl = new LongestValidParentheses();
		Assert.assertEquals(10, impl.longestValidParentheses("())(()())()())"));
		Assert.assertEquals(6, impl.longestValidParentheses("()(())"));
	}
}
