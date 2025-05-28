package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
 *
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 *
 * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
 *
 * 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.*/
public class Algorithm13549 {
    static final int MAX = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(s);
        dist[s] = 0;

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            if (cur == e) break;

            // 순간이동 (0초)
            int nx = cur * 2;
            if (nx < MAX && dist[nx] == -1) {
                dist[nx] = dist[cur];
                dq.offerFirst(nx);
            }

            // 걷기 (-1)
            nx = cur - 1;
            if (nx >= 0 && dist[nx] == -1) {
                dist[nx] = dist[cur] + 1;
                dq.offerLast(nx);
            }

            // 걷기 (+1)
            nx = cur + 1;
            if (nx < MAX && dist[nx] == -1) {
                dist[nx] = dist[cur] + 1;
                dq.offerLast(nx);
            }
        }

        System.out.println(dist[e]);
    }
}
