package org.example;

import java.util.Scanner;

public class BOJ4796 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int caseCount = 1;
		while (true) {
			int l = sc.nextInt();
			int p = sc.nextInt();
			int v = sc.nextInt();

			if (l == 0 && p == 0 && v == 0) {
				break;
			}

			if (v % p >= l) {
				int result = (v / p) * l + l;
				System.out.println("case " + caseCount + ": " + result);
			} else {
				int result = (v / p) * l + (v % p);
				System.out.println("case " + caseCount + ": " + result);
			}
			caseCount++;
		}
	}
}
