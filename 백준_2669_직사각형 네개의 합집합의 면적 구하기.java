package com.square2669;

import java.util.Scanner;

public class Main {
	static int[][] map;
	static int answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		map = new int[101][101];
		for (int i = 0; i < 4; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int width = c-a;
			int height = d-b;
			add(a,b,width,height);
		}
		countone();
		System.out.println(answer);
	}
	private static void countone() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(map[i][j]==1) {
					answer++;
				}
			}
		}
	}
	private static void add(int a, int b, int width, int height) {
		// TODO Auto-generated method stub
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				map[a+i][b+j]=1;
			}
		}
	}
}
