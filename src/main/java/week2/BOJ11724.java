package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11724 {

    static boolean visited[]; 

    static ArrayList<Integer>[] A;  // 정점마다 연결된 애들을 저장할 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        visited = new boolean[n + 1]; // 정점 번호는 1부터 시작하므로 n+1 크기로 생성

        A = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<Integer>(); // 각 정점의 인접 리스트 생성
        }

        // 간선 정보 입력받아, 무방향으로 그래프 구성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 간선의 시작점
            int v = Integer.parseInt(st.nextToken()); // 간선의 끝점
            A[u].add(v); // u -> v
            A[v].add(u); // v -> u (무방향 그래프이므로)
        }

        int count = 0; // 연결 요소 개수 선언

        // 모든 정점을 돌면서 DFS로 방문하지 않은 노드를 시작점으로 탐색
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { // 아직 방문하지 않았다면
                count++;        // 새로운 연결 요소 발견
                DFS(i);         // 해당 정점에서 DFS 수행
            }
        }

        System.out.println(count);
    }

    // DFS(깊이 우선 탐색) 함수
    private static void DFS(int e) {
        if (visited[e]) return; // 이미 방문했다면 리턴
        visited[e] = true;      // 현재 정점 방문 처리

        // 현재 정점과 연결된 모든 정점들에 대해 DFS 재귀 호출 -> 스택 오버플로에 유의!
        for (int i : A[e]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
