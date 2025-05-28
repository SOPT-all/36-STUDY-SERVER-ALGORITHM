package org.example.week4;

import java.util.Scanner;

public class Algorithm11726 {
        private static final int MOD = 10007;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            // 기저 사례
            if (n == 1) {
                System.out.println(1);
                return;
            }

            // 최소 메모리 사용: 변수 3개로 점화식 구현
            int prev2 = 1; // dp[0]
            int prev1 = 1; // dp[1]
            int curr = 0;

            for (int i = 2; i <= n; i++) {
                curr = (prev1 + prev2) % MOD;
                prev2 = prev1;
                prev1 = curr;
            }

            System.out.println(curr); // 최종 정답: dp[n]
        }
}

