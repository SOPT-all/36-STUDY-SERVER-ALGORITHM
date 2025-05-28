package org.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        String str = br.readLine();

        // '-' 기준으로 식을 나누기
        String[] split = str.split("-"); // ex) '10+20+30'-'40+10'-'20+10'

        // 나눈 식을 더하기
        for (String s : split) {
            int sum = 0;
            String[] split1 = s.split("\\+"); // "+" 기호를 기준으로 문자열 나누기 (정규표현식이므로 이스케이프 필요)
            // ex) '10'+'20'+'30', '40'+'10'
            for (String sp : split1) {
                sum += Integer.parseInt(sp); //60
            }
            list.add(sum); //60
        }

        // 리스트의 가장 첫 수는 더하기
        long result = list.get(0); //60

        // 그 다음 수부터 뺄셈
        for (int i = 1; i < list.size(); i++) {
            result -= list.get(i); //50, 30
        }

        System.out.println(result);
        br.close();
    }
}