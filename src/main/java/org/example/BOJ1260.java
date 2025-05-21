package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();

		visited = new boolean[n + 1];
		graph = new ArrayList[n + 1];

		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		// 인접리스트 그래프 초기화
		for (int i = 1; i <= m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			graph[start].add(end);
			graph[end].add(start);
		}

		// 작은 값부터 탐색을 진행하기 위해 정렬 필요
		for (int i = 1; i < n + 1; i++) {
			Collections.sort(graph[i]);
		}

		dfs(v);
		visited = new boolean[n + 1];
		System.out.println();
		bfs(v);

	}

	static void dfs(int v) {
		if(visited[v]) {
			return;
		}

		visited[v] = true;
		System.out.print(v + " ");

		for(int node : graph[v]) {
			if(!visited[node]) {
				dfs(node);
			}
		}
	}

	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;

		while(!queue.isEmpty()) {
			int currentNode = queue.poll();
			for(int i : graph[currentNode]) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}

			}
			System.out.print(currentNode+" ");
		}
	}
}
