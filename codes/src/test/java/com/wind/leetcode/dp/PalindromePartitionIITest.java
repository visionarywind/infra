package com.wind.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class PalindromePartitionIITest {
	@Test
	public void testMinCut() {
		Assert.assertEquals(1, PalindromePartitionII.minCut("co"));
		Assert.assertEquals(3, PalindromePartitionII.minCut("code"));
		Assert.assertEquals(1, PalindromePartitionII.minCut("cdd"));
		Assert.assertEquals(0, PalindromePartitionII.minCut("aa"));
		Assert.assertEquals(1, PalindromePartitionII.minCut("ab"));
		Assert.assertEquals(1, PalindromePartitionII.minCut("abaa"));
		Assert.assertEquals(1, PalindromePartitionII.minCut("adaasa"));
		Assert.assertEquals(2, PalindromePartitionII.minCut("acbcaaaba"));
	}
}
