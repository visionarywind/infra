package com.wind.newcoder;

import java.util.Comparator;
import java.util.Scanner;

public class DictSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int count = sc.nextInt();
			String[] arr = new String[count];
			for (int i=0; i!=count; i++) {
				arr[i] = sc.next();
			}

			quickSort(arr, 0, arr.length-1, genComparator());

			for (int i=0; i!=count; i++) {
				System.out.println(arr[i]);
			}
		}
	}

	private static Comparator<String> genComparator() {
		return (a, b) -> {
			int ret = 0;
			for (int i=0; i!=a.length() && i!=b.length(); i++) {
				int cp = compareAlpha(a.charAt(i), b.charAt(i));
				if (cp != 0) {
					ret = cp;
					break;
				}
			}
			if (ret == 0) {
				return a.length() - b.length();
			}
			return ret;
		};
	}

	private static int compareAlpha(char left, char right) {
		if (left > 'Z' && right <= 'Z') {	//左边为小写，右边为大写
			return 1;
		}
		if (left <= 'Z' && right > 'Z') {	//左边为大写，右边为小写
			return -1;
		}
		return left - right;
	}

	private static <T> void quickSort(T[] arr, int start, int end, Comparator<T> comparator) {
		if (start < end) {
			int pos = partition(arr, 0, end, comparator);
			quickSort(arr, 0, pos - 1, comparator);
			quickSort(arr, pos + 1, end, comparator);
		}
	}

	private static <T> int partition(T[] arr, int start, int end, Comparator<T> comparator) {
		T key = arr[end];
		int index = start;
		for (int i=start; i!=end; i++) {
			if (comparator.compare(arr[i], key) <= 0) {
				T tmp = arr[index];
				arr[index] = arr[i];
				arr[i] = tmp;
				index ++;
			}
		}
		arr[end] = arr[index];
		arr[index] = key;
		return index;
	}
}