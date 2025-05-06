package org.example;

import java.util.Scanner;

public class BOJ1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		String[] nums = str.split("-");

		for (int i = 0; i < nums.length; i++) {
			if(nums[i].contains("+")){
				String[] sub = nums[i].split("\\+");

				int subSum = Integer.parseInt(sub[0]);

				for (int j = 1; j < sub.length; j++) {
					subSum += Integer.parseInt(sub[j]);
				}
				nums[i] = String.valueOf(subSum);
			}
		}

		int result = Integer.parseInt(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			result -= Integer.parseInt(nums[i]);
		}
		System.out.println(result);
	}
}
