package com.wind.mi;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shanfeng on 7/12/18.
 */
public class FindSingleNumberTest {
	@Test
	public void testSolution() {
		String input = "10 10 11 12 12 11 16";
		String expected = "16";
		Assert.assertEquals(expected, FindSingleNumber.solution(input));
	}
}
