package org.week3;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

//    static List<List<Integer>> graph = new ArrayList<>();
    // 인접리스트 방식 -> 갈 수 없는지 체크가 어려움
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ROW, COL;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        graph = new int[ROW][COL];
        visited = new boolean[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            String line = br.readLine();
            for (int j = 0; j < COL; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(); // 시작점: (0,0)

        System.out.print(graph[ROW - 1][COL - 1]);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curPoint.x + dx[i];
                int ny = curPoint.y + dy[i];

                if (nx < 0 || nx >= ROW || ny < 0 || ny >= COL || visited[nx][ny] ) {
                    continue;
                }

                if (graph[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
                graph[nx][ny] = graph[curPoint.x][curPoint.y] + 1;
            }
        }
    }
}