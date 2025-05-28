package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11722 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] numbers = new int[n];
		int[] dp = new int[n];
		int max = 0;

		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		Arrays.fill(dp, 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (numbers[i] < numbers[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
