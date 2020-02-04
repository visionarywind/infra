package com.wind.leetcode.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        if (n < 0) {
            return Collections.emptyList();
        }

        List<Integer> c = new ArrayList<>(n);
        for (int i=1, end=10; i!=end; i++) {
            dfs(c, n, i);
        }
        return c;
    }

    private void dfs(List<Integer> c, int n, int cur) {
        if (cur <= n) {
            c.add(cur);
        }
        int tmp = cur * 10;
        if (tmp > n) { return ; }
        for (int i=0, end=10; i!=end; i++) {
            int val = tmp + i;
            dfs(c, n, val);
        }
    }
}
