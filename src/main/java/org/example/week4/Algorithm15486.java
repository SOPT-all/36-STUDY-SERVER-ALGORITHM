package org.example.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm15486 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 2];
        int[] t = new int[n];
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            // 오늘 상담 안 하는 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // i + t[i]일에 완료
            if (i + t[i] <= n) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
        }

        // 최종 최대 이익
        System.out.println(Math.max(dp[n], dp[n + 1]));
    }
}
