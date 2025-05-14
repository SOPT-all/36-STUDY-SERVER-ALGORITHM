package org.example;

import java.util.Scanner;

public class BOJ4963 {
	static int[][] map;
	static boolean[][] visited;
	// 이동할 경로 8방향에 대한 dx, dy를 미리 선언
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			int w = scanner.nextInt();
			int h = scanner.nextInt();

			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = scanner.nextInt();
				}
			}

			int result = 0;

			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					// 이미 방문했거나 바다인 경우 dfs를 호출하지 않고 넘어감
					if (!visited[y][x] && map[y][x] == 1) {
						result++;
						dfs(x, y, w, h);
					}
				}
			}

			System.out.println(result);
		}
	}

	static void dfs(int x, int y, int w, int h) {
		// 이미 방문한 곳이면 재귀 탈출
		if (visited[y][x]) {
			return;
		}

		visited[y][x] = true;

		// 8방향 모두를 순회하며 재귀 호출
		for (int i = 0; i < 8; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			// 지정된 범위를 넘어가면 재귀호출 생략
			if (newX < 0 || newY < 0 || newX >= w || newY >= h) {
				continue;
			}

			// 방문하지 않은 곳이고 땅인 경우에만 재귀 호출
			if (!visited[newY][newX] && map[newY][newX] == 1) {
				dfs(newX, newY, w, h);
			}
		}
	}
}
