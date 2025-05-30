package org.example;

import java.util.Scanner;

public class BOJ1890 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] numbers = new int[n][n];
		long[][] dp = new long[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				numbers[i][j] = sc.nextInt();
			}
		}

		// 출발지점 초기화
		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int distance = numbers[i][j];
				if (distance == 0) {
					break;
				}
				// 아래로 점프하는 경우를 계산하고 저장
				if (i + distance < n) {
					dp[i + distance][j] += dp[i][j];
				}
				// 오른쪽으로 점프하는 경우를 계산하고 저장
				if (j + distance < n) {
					dp[i][j + distance] += dp[i][j];
				}
			}
		}
		System.out.println(dp[n - 1][n - 1]);
	}
}
