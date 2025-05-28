package org.example.week4;

import java.util.Scanner;

public class BOJ11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bb = sc.nextInt();

        int[] cc = new int[bb + 2];

        cc[1] = 1;
        cc[2] = 2;

        for (int i = 3; i <= bb; i++) {
            cc[i] = (cc[i - 1] + cc[i - 2]) % 10007; // 10007로 나누기
        }

        System.out.println(cc[bb]);
    }
}
