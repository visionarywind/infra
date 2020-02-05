package com.wind.leetcode.string;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class ReverseWordsTest {
    @Tested
    private ReverseWords impl;

    @Test
    public void testReverseWords() {
        String[] inputs = { "the sky is blue", "  hello world!  ", "a good   example" };
        String[] expects = { "blue is sky the", "world! hello", "example good a" };
        for (int i=0; i!=inputs.length; i++) {
            System.out.println("compare : [" + inputs[i] + "]");
            Assert.assertEquals(expects[i], impl.reverseWords(inputs[i]));
        }
    }
}
