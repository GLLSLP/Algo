package com.hansoo1065;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int answer=0;
		if(N<100) {answer = N;}else {
			answer=99;
			for (int n = 100; n <= N; n++) {
				if(n/100-(n/10)%10==(n/10)%10-n%10) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
