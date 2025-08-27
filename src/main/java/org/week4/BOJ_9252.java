package org.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        // dp[i][j]: str1의 i번째 문자와 str2의 j번째 문자를 비교했을 시점에서 도출된 LCS 길이
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 문자가 일치하는 경우: dp[i][j] = dp[i-1][j-1] + 1
        // 문자가 일치하지 않는 경우: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        // dp[0][j]: C -> A(0) C(1) A(1) Y(1) K(1) P(1)
        // dp[1][j]: A -> A(1) C(1) A(2) Y(2) K(2) P(2)
        // dp[1][j]: P -> A(1) C(1) A(2) Y(2) K(2) P(3)
        // bottom-up
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = len1, j = len2;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) { // LCS 길이가 유지되는 쪽으로 이동
                i--;
            } else { // dp[i][j] == dp[i][j-1]
                j--;
            }
        }

        System.out.println(dp[len1][len2]);
        System.out.println(lcs.reverse());
    }

}