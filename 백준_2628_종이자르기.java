package com.papercutting2628;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int X, Y;
	static boolean[] rs;
	static boolean[] cs;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();

		map = new int[X][Y];
		rs = new boolean[X];
		cs = new boolean[Y];
		
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int flag = sc.nextInt();
			int dot = sc.nextInt(); // 잘리는 위치
			if (flag == 0) { // 가로
				rs[dot]=true;
			} else if (flag == 1) { // 세로
				cs[dot]=true;
			}
		}
		

		int last =0;
		int rmax = 0;
		for (int i = 0; i < X; i++) {
			if(rs[i]){
				rmax=Math.max(rmax, i-last);
				last = i;
			}
		}
		rmax = Math.max(rmax, X-last);
		
		last =0;
		int cmax = 0;
		for (int i = 0; i < Y; i++) {
			if(cs[i]){
				cmax=Math.max(cmax, i-last);
				last = i;
			}
		}
		cmax = Math.max(cmax, Y-last);
		
		System.out.println(rmax*cmax);
		
	}

}
