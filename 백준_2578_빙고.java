package com.bingo;

import java.util.Scanner;

public class Main {
	static int[][] pan;
	static int count;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pan = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				pan[i][j] = sc.nextInt();
			}
		}
//		printPan();

		go();
		System.out.println(count);
	}

	private static void go() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				count++; // 부른횟수
				int num = sc.nextInt();
				search(num);
//				System.out.println("현재번호" + num);
//				printPan();
				int bingo = isBingo();
				if (bingo >= 3) {
					return;
				}
			}
		}
	}

	private static int isBingo() {
		// TODO Auto-generated method stub
		int bing = 0;
		if (pan[0][0] + pan[1][1] + pan[2][2] + pan[3][3] + pan[4][4] == 0) {
			bing++;
		}
		if (pan[0][4] + pan[1][3] + pan[2][2] + pan[3][1] + pan[4][0] == 0) {
			bing++;
		}
		if (pan[0][0] + pan[0][1] + pan[0][2] + pan[0][3] + pan[0][4] == 0) {
			bing++;
		}
		if (pan[1][0] + pan[1][1] + pan[1][2] + pan[1][3] + pan[1][4] == 0) {
			bing++;
		}
		if (pan[2][0] + pan[2][1] + pan[2][2] + pan[2][3] + pan[2][4] == 0) {
			bing++;
		}
		if (pan[3][0] + pan[3][1] + pan[3][2] + pan[3][3] + pan[3][4] == 0) {
			bing++;
		}
		if (pan[4][0] + pan[4][1] + pan[4][2] + pan[4][3] + pan[4][4] == 0) {
			bing++;
		}
		if (pan[0][0] + pan[1][0] + pan[2][0] + pan[3][0] + pan[4][0] == 0) {
			bing++;
		}
		if (pan[0][1] + pan[1][1] + pan[2][1] + pan[3][1] + pan[4][1] == 0) {
			bing++;
		}
		if (pan[0][2] + pan[1][2] + pan[2][2] + pan[3][2] + pan[4][2] == 0) {
			bing++;
		}
		if (pan[0][3] + pan[1][3] + pan[2][3] + pan[3][3] + pan[4][3] == 0) {
			bing++;
		}
		if (pan[0][4] + pan[1][4] + pan[2][4] + pan[3][4] + pan[4][4] == 0) {
			bing++;
		}
//		System.out.println("빙고수" + bing);
		return bing;
	}

	private static void search(int num) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (pan[i][j] == num) {
					pan[i][j] = 0;
				}
			}
		}
	}

	private static void printPan() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(pan[i][j] + " ");
			}
			System.out.println();
		}
	}

}
