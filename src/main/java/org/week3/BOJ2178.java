package org.week3;

import java.awt.*;
import java.io.*;
import java.util.*;

public class BOJ2178{
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static int arr[][],N,M;
    static boolean visit[][];

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M]; // 미로 정보
        visit = new boolean[N][M];

        for(int i =0; i<N; i++){
            String s = br.readLine();
            for(int j =0; j<M; j++){
                arr[i][j] = s.charAt(j)- '0'; // 문자를 정수로 변환해서 저장 ('1' -> 1)
            }
        }

        bfs(0,0); // BFS 탐색 시작 (시작 위치는 (0, 0))

        System.out.println(arr[N-1][M-1]); // 도착 지점(N-1, M-1)에 저장된 값 출력
    }

    static void bfs(int x, int y){
        Queue<Point> que = new LinkedList<>(); // Point 클래스는 좌표 상의 위치를 나타내는데 사용
        que.add(new Point(x,y)); // 시작점을 큐에 추가
        visit[x][y]=true; // 시작점 방문 처리

        while(!que.isEmpty()){
            Point p = que.poll(); // 큐에서 한 점을 꺼내기
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i]; // 다음 x 좌표
                int ny = p.y + dy[i];

                // 범위 내이고, 아직 방문하지 않았으며, 갈 수 있는 길(1)인 경우
                if( 0 <= nx && nx < N && 0 <= ny && ny < M && !visit[nx][ny] && arr[nx][ny] > 0 ){
                    que.add(new Point(nx, ny)); // 다음 위치를 큐에 추가
                    visit[nx][ny] = true;
                    arr[nx][ny] = arr[p.x][p.y] + 1; // 이전 칸의 값 + 1을 현재 칸에 저장 (거리 누적)
                }
            }
        }
    }
}