package com.wind.newcoder;

import java.util.HashMap;

public class EquationTransformation {
    private HashMap<String, Integer> map = new HashMap<>();
    // 1、2、3..9 = target
    public int equationTransform(int target) {
        return search(8, 9, target, 1);
    }
    private int search(int limit, int sum, int target, int pow) {
        String key = String.valueOf(limit) + String.valueOf(sum) + String.valueOf(pow);
        Integer result = map.get(key);
        if (result != null) { return result; }
        if (limit == 0) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int addition = search(limit - 1, limit + sum, target, 1);
        int subtraction = search(limit - 1, limit - sum, target, 1);
        int multiplication = search(limit - 1, limit * (int)Math.pow(10, pow) + sum, target, pow + 1);
        int ret = addition + subtraction + multiplication;
        map.put(key, ret);
        return ret;
    }
}
