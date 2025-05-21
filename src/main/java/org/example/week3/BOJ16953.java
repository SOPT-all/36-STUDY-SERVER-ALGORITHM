package org.example.week3;

import java.util.Scanner;

public class BOJ16953 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ss = sc.nextLong();
        long tt = sc.nextLong();

        int cnt = 1;

        while (tt > ss) {
            if (tt % 10 == 1) {
                tt /= 10;
                cnt++;
            } else if (tt % 2 == 0) {
                tt /= 2;
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(tt == ss ? cnt : -1);
    }
}