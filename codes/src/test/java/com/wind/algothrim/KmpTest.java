package com.wind.algothrim;

import java.util.List;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.wind.leetcode.Utils;
import com.wind.util.Pair;

@RunWith(JMockit.class)
public class KmpTest {
    @Tested
    private Kmp impl;

    private List<Pair<String, String>> input;
    private List<Integer> output;

    @Before
    public void setUp() {
        input = Utils.newArrayList(
            Pair.valueOf("aabaa", "a"),
            Pair.valueOf("aabaa", "ab"),
            Pair.valueOf("aabaa", "bb"),
            Pair.valueOf("aabaa", "aba")
        );

        output = Utils.newArrayList(4, 1, 0, 1);
    }

    @Test
    public void testCount() {
        for (int i=0, end=input.size(); i<end; i++) {
            String src = input.get(i).getKey();
            String target = input.get(i).getValue();
            Assert.assertEquals(output.get(i).intValue(), impl.count(src, target));
        }
    }

    @Test
    public void testPrefix() {
        String s1 = "ababcaba";
        int[] r1 = { 0, 0, 1, 2, 0, 1, 2, 3 };
        Assert.assertEquals(r1, impl.kmpPrefix(s1));
    }
}
