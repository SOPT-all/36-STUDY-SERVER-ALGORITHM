package org.example;

import java.util.Scanner;

public class BOJ1520 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map, dp;
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[n][m];
		dp = new int[n][m];

		// 갔던 경로를 0, 목적지 도달 시 재귀가 풀리며 1씩 카운트하기 위해 -1로 초기화
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0));
	}

	static int dfs(int x, int y) {
		// 목적지에 도착하면 1을 반환 -> 재귀가 return을 통해 현재 경로에 1을 다 반환
		if (x == m - 1 && y == n - 1) {
			return 1;
		}

		// 이미 갔던 경로이면 카운트된 값을 반환
		if(dp[y][x] != -1){
			return dp[y][x];
		}

		// 새로운 경로이면 0으로 초기화 -> 도착지에 도착하면 1이 반환되어 1씩 커짐
		dp[y][x] = 0;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0
					&& nextX < m
					&& nextY >= 0
					&& nextY < n
					&& map[nextY][nextX] < map[y][x]) {
				// 현재 경로의 카운트 값에 새로운 경로의 탐색 결과를 누적
				dp[y][x] += dfs(nextX, nextY);
			}
		}
		// 재귀 풀릴 때 출발점에 경로 카운트 결과가 누적되어 반환됨
		return dp[y][x];
	}
}
