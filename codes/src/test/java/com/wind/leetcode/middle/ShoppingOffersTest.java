package com.wind.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JMockit.class)
public class ShoppingOffersTest {
    @Tested private ShoppingOffers impl;

    @Test
    public void testShoppingOffers() {
        // [2,5], [[3,0,5],[1,2,10]], [3,2] -> 14
        List<Integer> priceList1 = new ArrayList<Integer>() {{
            Integer[] c = { 2, 5 }; addAll(Arrays.asList(c));
        }};
        List<List<Integer>> offerList1 = new ArrayList<List<Integer>>() {{
            Integer[][] c = { { 3, 0, 5 }, { 1, 2, 10 } };
            for (int i=0; i!=c.length; i++) { add(Arrays.asList(c[i])); }
        }};
        List<Integer> needList1 = new ArrayList<Integer>() {{
            Integer[] c = { 3, 2 }; addAll(Arrays.asList(c));
        }};
        Assert.assertEquals(14, impl.shoppingOffers(priceList1, offerList1, needList1));


        // [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1] -> 11
        List<Integer> priceList2 = new ArrayList<Integer>() {{
            Integer[] c = { 2, 3, 4 };
            addAll(Arrays.asList(c));
        }};
        List<List<Integer>> offerList2 = new ArrayList<List<Integer>>() {{
            Integer[][] c = { { 1, 1, 0, 4 }, { 2, 2, 1, 9 }};
            for (int i = 0; i != c.length; i++) {
                add(Arrays.asList(c[i]));
            }
        }};
        List<Integer> needList2 = new ArrayList<Integer>() {{
            Integer[] c = { 1, 2, 1 };
            addAll(Arrays.asList(c));
        }};
        Assert.assertEquals(11, impl.shoppingOffers(priceList2, offerList2, needList2));
    }
}
