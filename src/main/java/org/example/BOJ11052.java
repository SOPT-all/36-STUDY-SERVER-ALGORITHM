package org.example;

import java.util.Scanner;

public class BOJ11052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			p[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				// 카드 구매 비용 메모이제이션
				dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
			}
		}
		System.out.println(dp[n]);
	}
}
