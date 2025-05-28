package org.example;

import java.util.Scanner;

public class BOJ15486 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 인덱스 맞추기용 +1, 퇴사 날짜까지 카운트 +1
		int[] t = new int[n + 2];
		int[] p = new int[n + 2];
		int[] dp = new int[n + 2];

		for (int i = 1; i <= n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}

		for (int i = 1; i <= n + 1; i++) {
			// 상담을 안 한 경우 이전 날짜의 수익을 가져와서 비교 후 대입
			dp[i] = Math.max(dp[i], dp[i - 1]);

			// 상담을 하는 경우 상담 종료일에 추가된 수익과 기존 수익을 비교하여 대입
			if (i + t[i] <= n + 1) {
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}
		}

		System.out.println(dp[n + 1]);
	}
}
