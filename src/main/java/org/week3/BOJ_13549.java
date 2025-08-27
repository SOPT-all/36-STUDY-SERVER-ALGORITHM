package org.week3;

import java.io.*;
import java.util.*;

public class BOJ_13549 {
    static int MAX = 100000;
    static int[] minTime = new int[MAX + 1];
    // minTim[i] = -1 -> i는 방문 X
    // minTime[i]: i까지 걸리는 최소시간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Arrays.fill(minTime, -1); // -1은 아직 방문 안 함 의미

        bfs(N);
        System.out.println(minTime[K]);
    }

    // [ 0-1 BFS ]
    // 가중치(걸리는 시간) 0과 1로 이뤄진 그래프에서 최단 경로를 찾는 문제
    private static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        minTime[start] = 0;
        deque.add(start);

        while (!deque.isEmpty()) {
            int curX = deque.poll();

            int[] nextX = {curX * 2, curX - 1, curX + 1};
            for (int i = 0; i < 3; i++) {
                int nx = nextX[i];

                if (nx < 0 || nx > MAX) continue;
                if (minTime[nx] != -1) continue; // 이미 방문한 지점인 경우 = 이미 최소 도달 시간이 확정

                // 0초에 가는 경우(순간이동)가 우선 순위 높음 -> Deque 앞에 넣는다
                if (i == 0) {
                    minTime[nx] = minTime[curX];
                    deque.addFirst(nx);
                } else {
                    minTime[nx] = minTime[curX] + 1;
                    deque.addLast(nx);
                }
            }
        }
    }
}