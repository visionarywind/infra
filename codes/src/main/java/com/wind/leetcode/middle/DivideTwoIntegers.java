package com.wind.leetcode.middle;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if (divisor == Integer.MIN_VALUE) {
			return dividend == Integer.MIN_VALUE ? 1 : 0;
		}

		long dividendL = dividend > 0 ? dividend : -(long)dividend;
		long divisorL = divisor > 0 ? divisor : -(long)divisor;
		if (dividendL < divisorL) {
			return 0;
		}
		boolean isNegative = (dividend > 0) ^ (divisor > 0);
		long quotient = recurse(dividendL, divisorL, divisorL, 1);
		quotient = isNegative ? -quotient : quotient;
		if (quotient <= Integer.MAX_VALUE && quotient >= Integer.MIN_VALUE) {
			return (int)quotient;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	private long recurse(long dividend, long divisor, long init, long quotient) {
		if (dividend > divisor) {
			return recurse(dividend, divisor<<1, init, quotient<<1);
		} else if (dividend == divisor) {
			return quotient;
		} else {
			long remainder = dividend - (divisor>>1);
			if (remainder >= init) {
				return recurse(remainder, init, init, 1) + (quotient>>1);
			} else {
				return quotient>>1;
			}
		}
	}
}
