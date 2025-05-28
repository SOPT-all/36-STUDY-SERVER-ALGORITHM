package org.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    static int[][] arr; // 정점들의 연결 관계를 저장하는 2차원 배열 (인접 행렬)
    static boolean[] visited; // 방문 여부 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수
        int V = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점의 번호


        // [해당 정점][그 정점과 만나는 다른 정점]
        arr = new int[N+1][N+1]; // 정점들이 만나는지 표시, 1부터 시작

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
            // 입력으로 주어지는 간선은 양방향이므로 둘 다 체크
        }

        visited = new boolean[N+1]; // 방문 여부
        dfs(V);

        System.out.println();

        visited = new boolean[N+1]; // visited 초기화
        bfs(V);
    }

    // dfs: 재귀 방식
    static void dfs(int V) {
        visited[V] = true; // 방문한 정점
        System.out.print(V + " ");

        if(V > arr.length - 1) {
            return;
        }

        for(int node = 1; node < arr.length; node++) {
            // 연결된 두 정점에다 아직 방문하지 않았으면
            if(arr[V][node] == 1 && visited[node] == false) {
                dfs(node); // dfs(j) 함수를 재귀 호출
            }
        }
    }

    // bfs: 큐(queue) 사용
    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(V); // 큐에 해당 정점 번호를 넣기
        visited[V] = true; // 방문 표식
        System.out.print(V + " ");

        while(!queue.isEmpty()) {
            int temp = queue.poll(); // 큐에 담겨있는 번호 중 가장 앞의 값 꺼내서 temp에 저장 (현재 탐색 중인 정점)
            for(int node = 1; node < arr.length; node++) {
                if(arr[temp][node] == 1 && visited[node] == false) { // 해당 노드와 연결된 다른 노드가 있고 그 다른 노드를 아직 방문하지 않았다면
                    queue.add(node); // 현재 정점 temp와 연결된 다른 정점들을 큐에 넣고 방문 처리
                    visited[node] = true;
                    System.out.print(node + " ");
                }
            }
        }
    }
}