package com.wind.algothrim;

public class Manacher {
    // aba ->   $ # a # b # a #
    //          1 1 2 1 4 1 3 1
    public int manacher(String src) {
        String expended = expended(src);
        int id = 0;
        int mx = 0;
        int max = 0;
        int[] p = new int[expended.length()];
        for (int i=1, end=expended.length(); i!=end; i++) {
            if (i < mx) {
                p[i] = Math.min(p[2*id - i], mx - i);
            } else {
                p[i] = 1;
            }

            while (i + p[i] < end && expended.charAt(i - p[i]) == expended.charAt(i + p[i])) {
                p[i] ++;
            }

            if (mx < i + p[i]) {
                id = i;
                mx = i + p[i];
            }

            max = Math.max(max, p[i] - 1);
        }
        return max;
    }

    private String expended(String src) {
        StringBuilder sb  = new StringBuilder();
        sb.append('$');
        for (int i=0, end=src.length(); i!=end; i++) {
            sb.append('#').append(src.charAt(i));
        }
        sb.append('#');
        return sb.toString();
    }
}
