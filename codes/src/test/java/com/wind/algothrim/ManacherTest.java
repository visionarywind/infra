package com.wind.algothrim;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class ManacherTest {
    @Tested
    Manacher impl;
    @Test
    public void testManacher() {
        String[] array = { "aba", "a", "abab", "abadaghgadcebad", "asdaasdaudwaa" };
        int[] expected = { 3, 1, 3, 7, 2 };
        for (int i=0; i!=array.length; i++) {
            Assert.assertEquals(impl.manacher(array[i]), expected[i]);
        }
    }
}
