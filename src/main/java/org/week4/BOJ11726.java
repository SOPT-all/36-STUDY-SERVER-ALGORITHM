package org.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        // 예외 처리
        dp[1] = 1;
        if(n >= 2) {
            dp[2] = 2;
        }

        //1 1
        //2 2
        //3 3
        //4 5
        //5 8

        // 피보나치 수열 이용
        for(int i = 3 ; i <= n ; i++) {
            dp[i] = (dp[i-2] + dp[i-1])%10007;
        }

        System.out.println(dp[n]);
    }
}