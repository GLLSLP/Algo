package com.organic;

import java.util.Scanner;

public class Main {
	static int T;
	static int M;
	static int N;
	static int K;
	static int [][]farm;
	static boolean [][]visit;
	static int [][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int bug;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=0;t<T;t++) {
			M = sc.nextInt();	//가로
			N = sc.nextInt();	//세로
			K = sc.nextInt();	//배추위치
			
			farm = new int[N][M];
			visit = new boolean[N][M];
			bug=0;
			
			for(int k=0;k<K;k++) {
				int x = sc.nextInt();	//가로위치
				int y = sc.nextInt();	//세로위치
				farm[y][x] = 1;
			}
			
			for(int y=0;y<N;y++) {
				for(int x=0;x<M;x++) {
					if(visit[y][x]==false && farm[y][x]==1) {
						dfs(y,x);
						bug++;

					}
				}
			}
			
			System.out.println(bug);
		}
	}
	private static void dfs(int y, int x) {
		// TODO Auto-generated method stub
		visit[y][x] = true;
		for(int i=0;i<4;i++) {
			int nextX = x+dir[i][0];
			int nextY = y+dir[i][1];
			if(nextX>=0 && nextX<M && nextY>=0 && nextY<N) {
				if(visit[nextY][nextX]==false && farm[nextY][nextX]==1) {
					dfs(nextY,nextX);
				}
			}
		}
	}

}
