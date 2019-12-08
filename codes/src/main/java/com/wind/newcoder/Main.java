package com.wind.newcoder;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			while (sc.hasNext()) {
				String input = sc.nextLine();
				System.out.println(input);
			}
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}