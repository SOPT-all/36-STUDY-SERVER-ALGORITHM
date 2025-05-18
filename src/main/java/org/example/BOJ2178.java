package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] maze;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine(); // 개행문자 소비 -> bufferedReader사용하면 안 써도 됨

		maze = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			String[] numbers = line.split("");

			for (int j = 0; j < m; j++) {
				maze[i][j] = Integer.parseInt(numbers[j]);
			}
		}
		bfs(0, 0, n, m);

		System.out.println(maze[n - 1][m - 1]);
	}

	static void bfs(int x, int y, int n, int m) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] {x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] currentVisited = queue.poll();

			for (int i = 0; i < 4; i++) {
				int newX = currentVisited[0] + dx[i];
				int newY = currentVisited[1] + dy[i];

				if (newX < 0 || newY < 0 || newX >= n || newY >= m) {
					continue;
				}

				if (!visited[newX][newY] && maze[newX][newY] != 0) {
					visited[newX][newY] = true;
					maze[newX][newY] = maze[currentVisited[0]][currentVisited[1]] + 1;
					queue.add(new int[] {newX, newY});
				}
			}
		}
	}
}
