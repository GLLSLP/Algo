package com.colorpaper;

import java.util.Scanner;

public class Main {
	static int[][] paper;
	static int size;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		paper = new int[101][101];
		int f = sc.nextInt();
		for (int i = 0; i < f; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			makeone(x, y);
		}

		onecount();
		System.out.println(size);
	}

	private static void onecount() {
		// TODO Auto-generated method stub
//		System.out.println("계산");
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (paper[i][j] == 1) {
					size++;
				}
			}
		}
	}

	private static void makeone(int x, int y) {
		// TODO Auto-generated method stub
//		System.out.println("시작");
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
//				System.out.println(x + r + "랑" + (y + c));
				paper[x + r][y + c] = 1;
			}
		}
	}

}
