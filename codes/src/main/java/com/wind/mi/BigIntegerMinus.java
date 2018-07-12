package com.wind.mi;

/**
 * Created by shanfeng on 7/12/18.
 *
 描述
 两个长度超出常规整形变量上限的大数相减，请避免使用各语言内置大数处理库，如 Java.math.BigInteger 等。

 输入
 有 N 行测试数据，每一行有两个代表整数的字符串 a 和 b，长度超过百位。规定 a>=b，a, b > 0。
 测试结果可以用 linux 小工具 bc进行测试是否正确。

 输出
 返回表示结果整数的字符串。

 输入样例
 1231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739870 - 89513312312312378127398789513312312312378127398789513312312312378127398789513

 1231231237812739878951331231231237812739878951331231231237812739878951331230000000000000000000000001 - 331231231237812739878951331231231

 输出样例
 1231231237812739878951331231231237812739878951331231231237812650365639018918853110413950365639018918853110413950365639018918853110413950357

 1231231237812739878951331231231237812739878951331231231237812739878620099998762187260121048668768770
 *
 */
public class BigIntegerMinus {
	public static String solution(String line) {
		// 在此处理单行数据
		String[] array = line.split("-");
		String left = array[0].substring(0, array[0].length()-1);
		String right = array[1].substring(1, array[1].length());
		boolean borrowed = false;
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		for (int i=left.length()-1, end=-1, j=right.length()-1; i!=end; i--) {
			int a = left.charAt(i) - '0' + (borrowed ? -1 : 0);
			int b = 0;
			if (j != -1) {
				b = right.charAt(j) - '0';
				j --;
			}
			if (a < b) {
				a += 10;
				borrowed = true;
			} else {
				borrowed = false;
			}
			sb.append(a - b);
		}
		String result = sb.reverse().toString();
		int pos = 0;
		int end = result.length() - 1;
		while (pos != end) {
			if (result.charAt(pos) == '0') {
				pos ++;
			} else {
				break;
			}
		}
		// 返回处理后的结果
		return result.substring(pos, result.length());
	}
}
