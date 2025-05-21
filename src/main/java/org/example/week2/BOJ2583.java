import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                             //StringBuilder sb = new StringBuilder();
                                             //String[] input = br.readLine().split(" ");
                                             //int n = Integer.parseInt(input[0]);
                                             //int m = Integer.parseInt(input[1]);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int num = sc.nextInt();

        int[][] map = new int[n][m];

        for (int i = 0; i < num; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[y][x] = 1;
                }
            } // 1로 칠하기~
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1}; // 상하좌우만 함

        List<Integer> xy = new ArrayList<>(); // 넓이 저장~

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (map[i][j] == 0 && !visited[i][j]) { // 0이면 빈공간~
                    int xy2 = 0; // 넓이 누적 ~ 해야지
                    Stack<int[]> s = new Stack<>();
                    s.push(new int[]{i, j});
                    visited[i][j] = true;

                    while (!s.isEmpty()) {
                        int[] a = s.pop();
                        int x = a[0];
                        int y = a[1];
                        xy2++;

                        // 4방향으로 탐색
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == 0) {
                                visited[nx][ny] = true;
                                s.push(new int[]{nx, ny});
                            }
                        }
                    }

                    xy.add(xy2);
                }
            }
        }

        System.out.println(xy.size());
        Collections.sort(xy); // 출력할 때 정렬해서 해야됨!!
        for (int xy3 : xy) {
            System.out.print(xy3 + " ");
        }
        sc.close();
    }
}