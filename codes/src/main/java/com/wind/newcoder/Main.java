package com.wind.newcoder;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (sc.hasNext()) {
                String input = sc.nextLine();
                System.out.println(freqAlphabets(input));
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    public static  String freqAlphabets(String s) {
        if (s == null || s.length() == 0) { return s; }
        if (s.length() == 1) { return Character.toString((char)('a' + s.charAt(0) - '0' - 1)); }
        if (s.length() == 2) {
            return freqAlphabets(s.substring(0, 1)) + freqAlphabets(s.substring(1));
        }
        if (s.charAt(2) == '#') {
            return Character.toString((char)('j' + Integer.valueOf(s.substring(0, 2)) - 10)) + freqAlphabets(s.substring(3));
        } else {
            return Character.toString((char)('a' + s.charAt(0) - '0' - 1)) + freqAlphabets(s.substring(1));
        }
    }

    private static String transform(String src, int step) {
        int index = src.indexOf('-');
        if (index < 0) {
            return src;
        }
        StringBuilder sb = new StringBuilder(src.substring(0, index));
        int calc = 0;
        for (int i=index+1; i<src.length(); i++) {
            if (calc == 0) {
                sb.append('-');
            }
            char ch = src.charAt(i);
            if (ch == '-') {
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)('A' + ch - 'a');
            }
            sb.append(ch);
            calc ++;
            if (calc == step) {
                calc = 0;
            }
        }
        return sb.toString();
    }

    private static String transform2(String src, int step) {
        String[] array = src.split("-");
        if (array.length < 2) {
            return src;
        }
        StringBuilder sb = new StringBuilder(array[0]);
        sb.append('-');
        int calc = 0;
        for (int i=1; i<array.length; i++) {
            String str = array[i];
            calc = fill(str, calc, step, sb);
        }
        if (calc == 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private static int fill(String src, int calc, int step, StringBuilder sb) {
        for (int i=0; i<src.length(); i++) {
            calc ++;
            char ch = src.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)('A' + ch - 'a');
            }
            sb.append(ch);
            if (calc == step) {
                sb.append('-');
                calc = 0;
            }
        }
        return calc;
    }
}
