package week2;

import java.util.*;

public class Algorithm2583 {
    static int M, N, K;
    static int[][] grid;
    static boolean[][] visited;
    static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    static int dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[y][x] = true;
        int areaSize = 1;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0], cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + DIRECTIONS[i][0], ny = cy + DIRECTIONS[i][1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[ny][nx] && grid[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    stack.push(new int[]{nx, ny});
                    areaSize++;
                }
            }
        }
        return areaSize;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        grid = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    grid[y][x] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x] && grid[y][x] == 0) {
                    areas.add(dfs(x, y));
                }
            }
        }

        Collections.sort(areas);
        System.out.println(areas.size());
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }
}
