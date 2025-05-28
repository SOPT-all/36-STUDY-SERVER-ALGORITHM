package org.example.week3;

import java.util.*;

public class BOJ1260 {

    static int v, e, s;
    static ArrayList<Integer>[] g;
    static boolean[] vst;
    static StringBuilder sbDfs = new StringBuilder();
    static StringBuilder sbBfs = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        s = sc.nextInt();

        g = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        for (int i = 1; i <= v; i++) Collections.sort(g[i]);

        vst = new boolean[v + 1];
        dfs(s);
        System.out.println(sbDfs.toString().trim());

        vst = new boolean[v + 1];
        bfs(s);
        System.out.println(sbBfs.toString().trim());
    }

    static void dfs(int cur) {
        vst[cur] = true;
        sbDfs.append(cur).append(" ");
        for (int nxt : g[cur]) {
            if (!vst[nxt]) dfs(nxt);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vst[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sbBfs.append(cur).append(" ");
            for (int nxt : g[cur]) {
                if (!vst[nxt]) {
                    vst[nxt] = true;
                    q.add(nxt);
                }
            }
        }
    }
}
