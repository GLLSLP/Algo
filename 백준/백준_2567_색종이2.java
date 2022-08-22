package com.colorpaper2;

import java.util.Scanner;

public class Main {
	static int [][]map;
	static int paper;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		paper=sc.nextInt();
		map = new int[101][101]; //0~100
		for (int i = 0; i < paper; i++) {
			int x = sc.nextInt();	//왼쪽아래 xy번호
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();	
			fill(i+1,x,y,width,height);
//			print();
		}
		
		for (int i = 1; i <= paper; i++) {
			count(i);
		}
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j <= 20; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void count(int num) {
		// TODO Auto-generated method stub
		int c=0;
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if(map[i][j]==num) {
					c++;
				}
			}
		}
		System.out.println(c);
	}

	private static void fill(int num, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		for (int i = x; i < x+width; i++) {
			for (int j = y; j < y+height; j++) {
				map[i][j]=num;
			}
		}
	}

}
