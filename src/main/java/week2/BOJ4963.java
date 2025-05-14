package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963 {
    static int[][] arr;
    static boolean[][] visit; // 방문 정보

    static int[] dirX = {0, 0, -1 ,1, -1, 1, -1, 1};     // X축(좌우 및 대각선)
    static int[] dirY = {-1, 1, 0, 0, 1, 1, -1, -1};     // Y축(상하 및 대각선)

    // 현재 좌표
    static int w, h, nowX, nowY;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str;
        while (!(str = br.readLine()).equals("0 0")) {               // "0 0"이 입력되면 종료
            st = new StringTokenizer(str);
            w = Integer.parseInt(st.nextToken());    // 너비
            h = Integer.parseInt(st.nextToken());    // 높이

            arr = new int[h][w];
            visit = new boolean[h][w];

            // 지도 정보 입력
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island_count = 0;

            // 모든 좌표를 탐색하며 DFS 수행
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 아직 방문하지 않았고, 현재 위치가 땅(1)이라면
                    if (!visit[i][j] && arr[i][j] == 1) {
                        island_count++;    // 새로운 섬 발견 -> 카운트 증가
                        DFS(i, j);         // 해당 섬 전체를 방문 처리
                    }
                }
            }

            sb.append(island_count).append('\n');
        }

        System.out.println(sb);
    }

    // DFS: 연결된 땅 방문 처리
    static void DFS(int x, int y) {
        visit[x][y] = true;    // 현재 위치

        // 8방향 탐색
        for (int i = 0; i < 8; i++) {
            nowX = x + dirX[i];    // 다음 X 좌표
            nowY = y + dirY[i];    // 다음 Y 좌표

            // 배열 범위 안에 있고, 아직 방문하지 않았고, 땅(1)이라면
            if (nowX >= 0 && nowY >= 0 && nowX < h && nowY < w && !visit[nowX][nowY] && arr[nowX][nowY] == 1) {
                DFS(nowX, nowY);    // 그 위치로 이동 -> 재귀적으로 DFS 수행
            }
        }
    }
}
