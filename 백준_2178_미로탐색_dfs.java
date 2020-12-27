package com.maze;

import java.util.Scanner;

public class Main2 {
	static int N;
	static int M;
	static int[][] maze;
	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int move;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}

//		print();
		maze[0][0]=2;
		dfs(0, 0, 1);
		System.out.println(move);
	}

	private static void dfs(int x, int y, int m) {
		// TODO Auto-generated method stub
		maze[x][y]=2;
		if(x==N&&y==M) {
			move=m;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nextX=x+dir[i][0];
			int nextY=y+dir[i][1];
			if(nextX>=0&&nextX<N&&nextY>=0&&nextY<M) {
				if(maze[nextX][nextY]==1) {
					maze[nextX][nextY]=2;
					dfs(nextX,nextY, m++);
				}
			}
		}
	}
}