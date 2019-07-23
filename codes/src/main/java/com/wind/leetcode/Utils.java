package com.wind.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
	public static final <E> List<E> newArrayList(E... args) {
		return new ArrayList<E>() {{
			if (args != null && args.length != 0) {
				Arrays.stream(args).forEach(e -> add(e));
			}
		}};
	}

	@SuppressWarnings("unchecked")
	public static final <T> T[] subArray(T[] src, int start, int end) {
		Class clazz = src.getClass().getComponentType();
		T[] instance = (T[])( Array.newInstance(clazz, end - start));
		System.arraycopy(src, start, instance, 0, end - start);
		return instance;
	}

	public static String reverse(String src) {
		return new StringBuilder(src).reverse().toString();
	}
}
