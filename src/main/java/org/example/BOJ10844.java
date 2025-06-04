package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[n + 1][10];

		// n=1인 경우에 대한 초기화 진행
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			// 0으로 시작하는 계단 수의 개수
			dp[i][0] = dp[i - 1][1] % 1_000_000_000;
			for (int j = 1; j <= 9; j++) {
				if (j == 9) {
					// 9로 시작하는 계단수의 개수
					dp[i][j] = dp[i - 1][8] % 1_000_000_000;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
				}
			}
		}
		long result = 0;
		for (int i = 1; i <= 9; i++) {
			result += dp[n][i];
		}
		System.out.println(result % 1_000_000_000);
	}
}
