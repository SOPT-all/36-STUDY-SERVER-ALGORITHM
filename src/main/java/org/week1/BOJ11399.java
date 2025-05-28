package org.week1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 대기시간을 오름차순으로 정렬
        java.util.Arrays.sort(P);


        // 반복 덧셈을 통한 최소 대기시간 계산
        int result = 0;
        int count = 0;
        for (int p : P) {
            count += p; // 현재 사람의 대기시간을 누적
            result += count; // 누적된 대기시간을 결과에 더하기
        }

        System.out.println(result);
    }
}