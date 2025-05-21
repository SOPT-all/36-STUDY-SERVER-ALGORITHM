package org.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, B));
    }

    public static int bfs(int A, int B) {
        Queue<long[]> queue = new LinkedList<>(); // [현재 숫자, 연산 횟수]를 저장하는 큐
        queue.add(new long[]{B, 1});  // B부터 시작, 연산 횟수 1

        while (!queue.isEmpty()) {
            long[] current = queue.poll(); // 큐에서 현재 상태 꺼냄
            long num = current[0]; // 현재 숫자
            long count = current[1]; // 현재까지의 연산 횟수

            if (num == A) { // 목표 숫자 A에 도달하면 그때의 연산 횟수를 반환
                return (int) count;
            }

            // A보다 작아졌으면 더 이상 연산 불가
            if (num < A) continue;

            // 짝수면 2로 나눌 수 있음
            if (num % 2 == 0) {
                queue.add(new long[]{num / 2, count + 1});
            }

            // 끝자리가 1이면 10으로 나눠서 일의 자리를 제외함
            if (num % 10 == 1) {
                queue.add(new long[]{num / 10, count + 1});
            }
        }

        return -1; // 불가능한 경우
    }
}
