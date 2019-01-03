package com.wind.leetcode.middle;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class DivideTwoIntegersTest {
	@Tested
	private DivideTwoIntegers divideTwoIntegers;

	@Test
	public void testDivide() {
		Assert.assertEquals(3, divideTwoIntegers.divide(10, 3));
		Assert.assertEquals(-2, divideTwoIntegers.divide(7, -3));
		Assert.assertEquals(-33, divideTwoIntegers.divide(100, -3));
		Assert.assertEquals(2147483647, divideTwoIntegers.divide(-2147483648 ,-1));
		Assert.assertEquals(2147483647, divideTwoIntegers.divide(-2147483647 ,-1));
	}
}
