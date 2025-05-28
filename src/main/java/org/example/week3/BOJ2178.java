package org.example.week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {

    static int n, m;
    static int[][] mp;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        mp = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                mp[i][j] = s.charAt(j) - '0';
                dist[i][j] = 0;
            }
        }

        bfs(0, 0);
        System.out.println(dist[n - 1][m - 1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        dist[x][y] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (mp[nx][ny] == 1 && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}