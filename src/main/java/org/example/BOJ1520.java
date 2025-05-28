package org.example;

import java.io.*;

public class BOJ1520 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];



        bw.flush();
        bw.close();
        br.close();
    }
}
