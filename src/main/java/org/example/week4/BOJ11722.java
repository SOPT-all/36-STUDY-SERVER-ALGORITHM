package org.example.week4;

import java.util.Scanner;

public class BOJ11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] cc = new int[a];
        int[] dd = new int[a];

        for (int i = 0; i < a; i++) {
            cc[i] = sc.nextInt();
            dd[i] = 1;
        }

        for (int j = 1; j < a; j++) {
            for (int k = 0; k < j; k++) {
                if (cc[k] > cc[j] && dd[j] < dd[k] + 1) {
                    dd[j] = dd[k] + 1;
                }
            }
        }

        int hh = 0;
        for (int d : dd) {
            if (d > hh) {
                hh = d;
            }
        }

        System.out.println(hh);
    }
}
