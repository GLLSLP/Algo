package com.cooker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static int[] cnr;
	private static int[] sour;
	private static int[] bitter;
	private static int N;
	private static int c;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sour = new int[N];
		bitter = new int[N];
		cnr = new int[N];

		for (int i = 0; i < N; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		for (int i = 1; i < N + 1; i++) {
			c = i;
			combination(0, 0);
		}

		System.out.println(answer);
	}
	private static void combination(int cnt, int index) {

		if (c == cnt) {
			int totalSour = 1;
			int totalBitter = 0;
			for (int i = 0; i < c; i++) {
				totalSour *= sour[cnr[i]];
				totalBitter += bitter[cnr[i]];
			}
			answer = Math.min(min, Math.abs(totalBitter - totalSour));
			return;
		}

		for (int i = index; i < N; i++) {
			cnr[cnt] = i;
			combination(cnt + 1, i + 1);
		}

	}
}