package com.wind.leetcode.cn;

public class MaximumSwap {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        byte[] index = new byte[10];
        for (int i=0; i!=arr.length; i++) {
            index[arr[i] - '0'] += 1;
        }
        int begin = 9;
        int pos = 0;
        for (; pos!=arr.length; pos++) {
            while (index[begin] == 0) { begin --; }
            if (begin != arr[pos] - '0') { break; }
            else { index[begin] --; }
        }

        if (pos != arr.length) {
            int p = arr.length-1;
            while (arr[p] - '0' != begin) { p --; }
            char ch = arr[pos];
            arr[pos] = arr[p];
            arr[p] = ch;
            return Integer.valueOf(new String(arr));
        }
        return num;
    }

    public int maximum(int num) {
        if (num < 12) { return num; }
        int deep = 0;
        int tmp = num;
        while (tmp > 0) {
            deep ++;
            tmp /= 10;
        }
        tmp = num;
        for (int i=1, mx=num%10, mxnum=0; i!=deep; i++) {
            int cur = num / power(i) % 10;
            if (cur > mx) {
                mx = cur; mxnum = i;
            } else {
                int diff = mx - cur;
                diff = diff * (power(i) - power(mxnum)) + num;
                tmp = diff > tmp ? diff : tmp;
            }
        }
        return tmp;
    }

    private int power(int n) {
        int ret = 1;
        while (n > 0) { ret *= 10; n --; }
        return ret;
    }

    public int max(int num) {
        if (num < 12) {
            return num;
        }
        int deep = 0;
        int tmp = num;
        int mx = 0;
        while (tmp > 0) {
            if (tmp % 10 > mx) { mx = tmp % 10; }
            deep ++;
            tmp /= 10;
        }
        // 312 3
        int fval = num / pow10(deep - 1);
        if (fval == mx) {
            int npow = pow10(deep - 1) * mx;

            tmp = num - npow;
            int ndeep = 0;
            int nmx = 0;
            while (tmp > 0) {
                if (tmp % 10 > nmx) { nmx = tmp % 10; }
                ndeep ++;
                tmp /= 10;
            }
            if (ndeep+1 == deep) {
                return npow + max(num - npow);
            } else {
                tmp = num;
                num += nmx * pow10(deep - 2);
                for (fval=0; fval!=deep; fval++) {
                    if (tmp % 10 == nmx) { break; }
                    else { tmp /= 10; }
                }

                num -= nmx * pow10(fval);
                return num;
            }
        } else {
            tmp = num;
            int diff = mx - fval;
            num += diff * pow10(deep - 1);
            for (fval=0; fval!=deep; fval++) {
                if (tmp % 10 == mx) {
                    break;
                } else {
                    tmp /= 10;
                }
            }
            num -= diff * pow10(fval);
            return num;
        }
    }

    private int pow10(int n) {
        if (n == 0) { return 1; }
        else if (n == 1) { return 10; }
        else if (n == 2) { return 100; }
        if ( (n & 1) == 1) {
            return pow10(n/2) * pow10( n/2 ) * 10;
        } else {
            return pow10(n/2) * pow10(n / 2);
        }
    }

    private static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999 };
    private static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }
    public int maximumSwap2(int num) {
        int ssize = stringSize(num);
        byte[] arr = new byte[ssize];
        int shadow = num;
        while (shadow > 0) {
            int tmp = shadow / 10;
            arr[ssize - 1] = (byte)(shadow - tmp * 10 + '0');
            ssize --;
            shadow = tmp;
        }
        int i = 0;
        int j = 0;
        for (; i!=arr.length; i++) {
            j = arr.length - 1;
            for (; j!=i; j--) {
                if (arr[j] > arr[i]) { break; }
            }
            if (j != i) { break; }
        }
        if (i != arr.length) {
            for (int k=j; k!=i; k--) {
                if (arr[k] > arr[j]) {
                    j = k;
                }
            }

            byte tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            int ret = 0;
            for (int k=0; k!=arr.length; k++) {
                ret = ret * 10 + (arr[k] - '0');
            }
            return ret;
        } else {
            return num;
        }
    }
}
