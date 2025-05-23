package org.example;

import java.util.Scanner;

public class BOJ1463 {
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		dp = new int[x + 1];

		dp[1] = 0;

		// 각 인덱스마다 모든 연산을 수 행 후에 값을 비교하여 최소의 경우를 대입
		for (int i = 2; i <= x; i++) {
			dp[i] = dp[i - 1] + 1;

			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}
		System.out.println(dp[x]);
	}
}
