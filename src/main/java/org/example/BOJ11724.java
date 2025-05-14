package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ11724 {
	// 몇개의 그래프가 나오는지 알아내면 됨
	// 방향이 없는 그래프임을 유의

	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) {
		// 방문을 기록할 배열을 초기화
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int m = scanner.nextInt();

		// 인접 리스트의 인덱스 요소 초기화
		graph = new ArrayList[n + 1];

		// 방문 배열 초기화, 초기값 false
		visited = new boolean[n + 1];

		// 간선 수 만큼 빈 인접 리스트 생성
		// 노드는 1부터 시작하므로 반복문으로 초기화도 1부터 n+1까지
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();

			// 방향이 없으므로 양쪽 인접리스트에 다 추가
			graph[u].add(v);
			graph[v].add(u);
		}

		int dfsCount = 0;

		// 방문 배열 순회하면서 dfs를 실행
		for (int i = 1; i < n + 1; i++) {
			if(!visited[i]) {
				dfsCount++;
				dfs(i);
			}
		}

		System.out.println(dfsCount);
	}
	static void dfs(int node) {
		// 현재 노드의 방문 배열 값이 true이면 재귀 탈출
		if(visited[node]) {
			return;
		}

		// 현재 노드의 방문 배열 값이 false면 true로 변경
		visited[node] = true;

		// 인접 리스트를 보고 다음 탐색 진행
		for (int nextNode : graph[node]) {
			if(!visited[nextNode]) {
				dfs(nextNode);
			}
		}
	}
}
