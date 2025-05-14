import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if (n == 0 && m == 0) {
                break;
            } // 종료

            int[][] map = new int[m][n];
            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            } // 지도 입력

            int cnt = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) { // 1일 때가 땅! 1인 순간부터 시작

                        visited[i][j] = true;
                        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
                        int[] dy = {0, 0, -1, 1, -1, -1, 1, 1}; // 대각선도 섬. 1칸 이동 기준 8개 변화량 배열
                        
                        Stack<int[]> s = new Stack<>();
                        s.push(new int[]{i, j}); // 현재 위치부터 시작 ~

                        while (!s.isEmpty()) {
                            int[] a = s.pop();
                            int x = a[0], y = a[1]; // 가로 세로
                            
                            for (int d = 0; d < 8; d++) { // 8방향 방문
                                int nx = x + dx[d], ny = y + dy[d];

                                if (nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] == 1 && !visited[nx][ny]) { // 섬이고, 방문하지 않은 곳만
                                    visited[nx][ny] = true;
                                    s.push(new int[]{nx, ny}); // 모든 정점에 대하여 반복
                                }
                            }
                        }
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}