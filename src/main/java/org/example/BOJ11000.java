package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11000 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Lecture[] lectures = new Lecture[n];

		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();

			lectures[i] = new Lecture(s, t);
		}

		// 강의 시작 시간 기준 오름차순 정렬, 시작 시간이 캍으면 종료 시간 기준 오름차순 정렬
		Arrays.sort(lectures,
			(lec1, lec2) -> lec1.start == lec2.start ? lec1.end - lec2.end : lec1.start - lec2.start);

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// 종료시간으로 우선순위 큐 생성
		pq.offer(lectures[0].end);

		for (int i = 1; i < lectures.length; i++) {
			if(lectures[i].start >= pq.peek()) {
				pq.poll();
			}
			pq.offer(lectures[i].end);
		}
		System.out.println(pq.size());
	}
}

class Lecture {
	int start;
	int end;

	Lecture(int start, int end){
		this.start = start;
		this.end = end;
	}
}
