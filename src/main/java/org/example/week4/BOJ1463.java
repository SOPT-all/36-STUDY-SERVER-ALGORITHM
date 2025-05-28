package org.example.week4;

import java.util.Scanner;

public class BOJ1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bb = sc.nextInt();

        int[] cc = new int[bb + 1];
        cc[1] = 0; // 1은 0

        for (int dd = 2; dd <= bb; dd++) {
            cc[dd] = cc[dd - 1] + 1; // 3번 항상 가능

            if (dd % 2 == 0) {
                cc[dd] = Math.min(cc[dd], cc[dd / 2] + 1);
            }
            if (dd % 3 == 0) {
                cc[dd] = Math.min(cc[dd], cc[dd / 3] + 1);
            }
        }

        System.out.println(cc[bb]);
    }

}
