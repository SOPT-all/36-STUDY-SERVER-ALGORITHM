package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(x -> x[0]));
        boolean[] visit = new boolean[100001];
        queue.add(new int[]{0, n});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int time = poll[0];
            int position = poll[1];
            if(position == k){
                bw.append(String.valueOf(time));
                break;
            }

            if(visit[position]) continue;
            visit[position] = true;

            if(position * 2 <= 100000 && !visit[position * 2]){
                queue.add(new int[]{time, position * 2});
            }

            if(position > 0 && !visit[position - 1]){
                queue.add(new int[]{time + 1, position - 1});
            }

            if(position + 1 <= 100000 && !visit[position + 1]){
                queue.add(new int[]{time + 1, position + 1});
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
