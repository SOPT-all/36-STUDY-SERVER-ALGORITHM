package org.week1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 1;
        int L, P, V;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); // L일 동안 사용
            P = Integer.parseInt(st.nextToken()); // 연속하는 P일
            V = Integer.parseInt(st.nextToken()); // V일짜리 휴가

            if (L == 0 && P == 0 && V == 0)
                break;

            int result = (V / P) * L + Math.min(V % P, L); // 각 주기 * L일 캠핑 + 남은 일수 중 캠핑 가능한 최대 일수(Math.min으로 두 수 중 더 작은 값 구하기)
            bw.write("Case " + count + ": " + result + "\n");
            count++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}