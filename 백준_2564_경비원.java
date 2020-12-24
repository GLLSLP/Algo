package com.secure;

import java.util.Scanner;

public class Main {
	static int[] dist;
	static int circumference;
	static int C,R,N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		circumference=(C+R)*2;
		N = sc.nextInt();
		dist = new int[N+1];
		
		for (int n = 0; n < N+1; n++) {
			int x = sc.nextInt();	//위치
			int y = sc.nextInt();	//길이
			dist[n] = clock(x,y);
		}
		int sum = 0;
		
		for (int n = 0; n < N; n++) {
			int a = Math.abs(dist[N]-dist[n]);	//여길 dist[3]으로 하면 틀리고 dist[N]으로 하면 맞음
			sum += Math.min(a, circumference-a);
		}
		System.out.println(sum);
		
	}
	private static int clock(int idx, int pos) {
		if(idx==1) {//북
			return pos;
		}else if(idx==2) {//남
			return C+C+R-pos;
		}else if(idx==3) {//서
			return C+C+R+R-pos;
		}else {//동
			return C+pos;
		}
	}
}
