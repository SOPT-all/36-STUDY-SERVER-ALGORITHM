package week2;

import java.util.Scanner;

public class Algorithm4963 {
    static final int LAND = 1;
    static final int SEA = 0;

    static int[][] map;
    static boolean[][] visited;
    static int w, h;

    static final int[][] DIRECTIONS = {
            // 상하좌우
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            // 대각선
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                w = sc.nextInt();
                h = sc.nextInt();

                if (w == 0 && h == 0) break;

                map = new int[h][w];
                visited = new boolean[h][w];

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        map[i][j] = sc.nextInt();
                    }
                }

                System.out.println(cntIsland());
            }
        }
    }

    static int cntIsland() {
        int cnt = 0;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (map[y][x] == LAND && !visited[y][x]) {
                    dfs(x, y);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void dfs(int x, int y) {
        visited[y][x] = true;

        for (int[] dir : DIRECTIONS) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (isInBounds(nx, ny) && map[ny][nx] == LAND && !visited[ny][nx]) {
                dfs(nx, ny);
            }
        }
    }

    static boolean isInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < w && y < h;
    }
}
