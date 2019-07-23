package com.wind.algothrim;

import com.wind.leetcode.Utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Kmp {
    public int count(String src, String target) {
        if (src == null || target == null || src == "" || target == "") {
            return 0;
        }

        int cnt = 0;
        int[] partition = partMatch(target);

        for (int i=0, end=src.length()-target.length()+1; i<end; ) {
            int j = 0;
            while (j < target.length() && src.charAt(i+j) == target.charAt(j)) {
                j ++;
            }
            if (j == target.length()) {
                cnt ++;
            }
            if (j > 0) {
                i += j - partition[j - 1];
            } else {
                i ++;
            }
        }
        return cnt;
    }

    private int[] partMatch(String src) {
        int[] ret = new int[src.length()];

        for (int i=1, end=src.length(); i!=end; i++) {
            List<String> prefix = genPrefix(src.substring(0, i));
            List<String> suffix = genPrefix(Utils.reverse(src));

            int count = distinctCount(prefix, suffix);
            ret[i-1] = count;
        }

        return ret;
    }

    private List<String> genPrefix(String src) {
        List<String> prefix = new ArrayList<>(src.length());
        for (int i=0, end=src.length()-1; i!=end; i++) {
            prefix.add(src.substring(0, i));
        }
        return prefix;
    }

    private int distinctCount(Collection<String> left, Collection<String> right) {
        Set<String> set = new HashSet<String>() {{
            left.stream().forEach(e -> add(e));
        }};
        return Long.valueOf(right.stream().filter(e -> set.contains(e)).count()).intValue();
    }
}
