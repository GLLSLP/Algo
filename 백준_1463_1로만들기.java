package com.makeone;

import java.util.Scanner;

public class Main {

	static int num;
	static int count;
	static int[] dp = new int[100000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		System.out.println(cal(num));
	}

	public static int cal(int number) {
		for (int i = 2; i <= number; i++) { // 최종 숫자는 n이기 때문에 n까지 반복연산
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
		}
		return dp[number];

	}

}
