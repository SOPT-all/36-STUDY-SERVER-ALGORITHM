package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ16953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextInt();
		long b = sc.nextInt();

		long result = bfs(a, b);

		System.out.println(result);
	}

	static long bfs(long a, long b) {
		Queue<long[]> queue = new LinkedList<>();
		queue.add(new long[] {a, 1});

		while (!queue.isEmpty()) {
			long[] current = queue.poll();
			long currentPosition = current[0];
			long currentCount = current[1];

			if (currentPosition == b) {
				return currentCount;
			}

			// 13549와 달리 연산 과정에서 현재보다 작은 수가 되는 경우가 없으므로 b까지만 연산을 수행하고 count를 반환
			if (currentPosition * 10 + 1 <= b) {
				queue.offer(new long[] {currentPosition * 10 + 1, currentCount + 1});
			}
			if (currentPosition * 2 <= b) {
				queue.offer(new long[] {currentPosition * 2, currentCount + 1});
			}
		}
		return -1;
	}
}
