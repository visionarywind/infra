package com.wind.mi;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shanfeng on 7/12/18.
 */
public class LongestContinuousSeriesTest {
	@Test
	public void testSolution() {
		String input = "54,55,300,12,56";
		String expected = "3";
		Assert.assertEquals(expected, LongestContinuousSeries.solution(input));

		input = "100,4,200,1,3,2";
		expected = "4";
		Assert.assertEquals(expected, LongestContinuousSeries.solution(input));

		input = "54,55,300,12";
		expected = "2";
		Assert.assertEquals(expected, LongestContinuousSeries.solution(input));

		input = "1";
		expected = "1";
		Assert.assertEquals(expected, LongestContinuousSeries.solution(input));

		input = "5,4,3,2,1";
		expected = "5";
		Assert.assertEquals(expected, LongestContinuousSeries.solution(input));

		input = "1,2,3,4,5,6";
		expected = "6";
		Assert.assertEquals(expected, LongestContinuousSeries.solution(input));
	}
}
