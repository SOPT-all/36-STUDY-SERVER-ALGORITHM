package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ2178 {

    static int[][] iters = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[][] map = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String[] tmp = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }


        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(x -> x[0]));

        queue.add(new int[]{1, 0, 0});
        visit[0][0] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int cur = poll[0];
            int x = poll[1];
            int y = poll[2];

            if(x == n - 1 && y == m - 1) {
                bw.append(String.valueOf(cur));
                break;
            }

            for (int[] iter : iters) {
                int _x = x + iter[0];
                int _y = y + iter[1];

                if(_x >= 0 && _y >= 0 && _x < n && _y < m && !visit[_x][_y] && map[_x][_y] == 1){
                    visit[_x][_y] = true;
                    queue.add(new int[]{cur + 1, _x, _y});
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
