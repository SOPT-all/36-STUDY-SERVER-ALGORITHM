import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer>[] g = new ArrayList[n + 1]; // 인덱스 1부터 ~
        for (int i = 1; i <= n; i++) { // 각정점에 연결된 정점들 저장 ~
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g[u].add(v);
            g[v].add(u);
        } // 간선

        boolean[] visited = new boolean[n + 1];
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                cnt++;
                Stack<Integer> s = new Stack<>();
                s.push(i);
                visited[i] = true; // 방문

                while (!s.isEmpty()) {
                    int no = s.pop();
                    for (int no2 : g[no]) { // 연결 정점들 다 ~
                        if (!visited[no2]) {
                            s.push(no2);
                            visited[no2] = true;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
        sc.close();
    }
}