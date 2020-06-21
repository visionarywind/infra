package com.wind.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class RegularExpressionMatchingTest {
    @Test
    public void testIsMatch() {
        Assert.assertFalse(RegularExpressionMatching.isMatch("aa", "a"));
        Assert.assertTrue(RegularExpressionMatching.isMatch("aa", "a*"));
        Assert.assertTrue(RegularExpressionMatching.isMatch("aaba", "a*b*.*"));
        Assert.assertTrue(RegularExpressionMatching.isMatch("aab", "c*a*b"));
    }
}
