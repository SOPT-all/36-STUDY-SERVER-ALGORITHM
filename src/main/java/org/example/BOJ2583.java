package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ2583 {
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int area;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();

		visited = new boolean[m][n];

		for (int i = 0; i < k; i++) {
			int startX = sc.nextInt();
			int startY = m - sc.nextInt();
			int endX = sc.nextInt();
			int endY = m - sc.nextInt();

			// 직사각형의 영역을 true로 처리
			for (int j = endY; j < startY; j++) {
				for (int l = startX; l < endX; l++) {
					visited[j][l] = true;
				}
			}
		}

		int count = 0;
		List<Integer> areas = new ArrayList<>();

		// 직사각형이 존재하지 않는 영역에서만 DFS를 호출하고 횟수를 카운트
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					count++;
					area = 0;
					dfs(j,i,m,n);
					areas.add(area);
				}
			}
		}

		System.out.println(count);

		// 순서대로 출력하기 위해 정렬
		Collections.sort(areas);
		areas.forEach(x -> System.out.print(x + " "));
	}

	static void dfs(int x, int y, int m, int n) {
		// 현재 방문한 칸을 true로 변경하고 넓이에 1더하기
		visited[y][x] = true;
		area++;

		// 상, 하, 좌, 우를 탐색하고 아직 탐색되지 않은 좌표에서만 재귀 호출
		for(int i = 0; i<4; i++){
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX < 0 || newY < 0 || newX >= n || newY >= m) {
				continue;
			}

			if(!visited[newY][newX]) {
				dfs(newX, newY, m, n);
			}
		}
	}
}
