package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ13549 {
	/*
	 * bfs를 이용하며 도착지에서의 time을 카운트해야함
	 * 이동할 수 있는 경로는 순간이동 *2, +1, -1
	 * visited으로 이미 탐색된 경로의 탐색을 제한할 경우 최소 이동 경로를 찾는 과정이 제한됨
	 * visited 대신 시간을 기록하고 최소 시간으로 갱신, bfs를 끝까지 수행
	 */
	static int[] time;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		time = new int[100001];

		// 최솟값 비교를 위해 배열의 모든 원소를 가장 큰 값인 100000으로 초기화
		Arrays.fill(time, 100000);

		// 걸린 시간 계산을 위해 시작점의 시간을 0으로 변경
		time[n] = 0;
		bfs(n);

		System.out.println(time[k]);
	}

	static void bfs(int n) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {n, 0});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentPosition = current[0];
			int currentTime = current[1];

			// 주어진 범위 안이고 현재 탐색 경로의 시간이 기존 값보다 작으면 큐에 넣고 탐색을 진행, 시간 수정
			if (currentPosition * 2 <= 100000 && time[currentPosition * 2] > currentTime) {
				queue.offer(new int[] {currentPosition * 2, currentTime});
				time[currentPosition * 2] = currentTime;
			}
			if (currentPosition + 1 <= 100000 && time[currentPosition + 1] > currentTime + 1) {
				queue.offer(new int[] {currentPosition + 1, currentTime + 1});
				time[currentPosition + 1] = currentTime + 1;
			}
			if (currentPosition - 1 >= 0 && time[currentPosition - 1] > currentTime + 1) {
				queue.offer(new int[] {currentPosition - 1, currentTime + 1});
				time[currentPosition - 1] = currentTime + 1;
			}
		}
	}
}
