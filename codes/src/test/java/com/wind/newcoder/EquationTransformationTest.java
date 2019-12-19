package com.wind.newcoder;

import org.junit.Assert;
import org.junit.Test;

public class EquationTransformationTest {
    @Test
    public void testEquationTransform() {
        EquationTransformation impl = new EquationTransformation();
        Assert.assertEquals(21, impl.equationTransform(5));
        long t = System.currentTimeMillis();
        for (int i=0; i!=10000; i++) {
            impl.equationTransform(5);
        }
        long cost = System.currentTimeMillis() - t;
        System.out.println(cost);
    }
}
