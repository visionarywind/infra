package com.wind.leetcode.string;

/**
 *
 给定一个字符串，逐个翻转字符串中的每个单词。

  

 示例 1：

 输入: "the sky is blue"
 输出: "blue is sky the"
 示例 2：

 输入: "  hello world!  "
 输出: "world! hello"
 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 示例 3：

 输入: "a good   example"
 输出: "example good a"
 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
  

 说明：

 无空格字符构成一个单词。
 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) { return s; }
        int end = s.length() - 1;
        while (end > -1 && s.charAt(end) == ' ') { end --; }
        if (end == -1) { return ""; }
        char[] arr = new char[s.length()];
        int index = 0;
        for (int i=end, prev=end; i>-1; i--) {
            if (i == 0) {
                int start = s.charAt(i) == ' ' ? i+1 : i;
                index = copyReverse(arr, index, s, start, prev);
            } else if (s.charAt(i) == ' ') {
                index = copyReverse(arr, index, s, i+1, prev);
                do { i --; } while (i > -1 && s.charAt(i) == ' ');
                if (i == -1) {
                    break;
                } else if (i == 0) {
                    index = copyReverse(arr, index, s, i, i);
                    break;
                }
                prev = i;
            }
        }
        return new String(arr, 0, index);
    }

    private int copyReverse(char[] arr, int index, String s, int start, int end) {
        if (index != 0) {
            arr[index ++] = ' ';
        }
        while (start <= end) {
            arr[index ++] = s.charAt(start ++);
        }
        return index;
    }
}
