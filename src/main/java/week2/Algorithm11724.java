package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm11724 {

    static int[][] graph;
    static boolean[] visited;
    static int nodeCnt;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());

        graph = new int[nodeCnt + 1][nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        cnt = 0;
        for (int i = 1; i <= nodeCnt; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int currentNode) {
        visited[currentNode] = true;

        for (int i = 1; i <= nodeCnt; i++) {
            if (graph[currentNode][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}