package com.alphabet;

import java.util.Scanner;

public class Main {
	static int R;
	static int C;
	static char[][] board;
	static boolean[][] visit;
	static boolean[] alphabet;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int answer;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		R = sc.nextInt();
		C = sc.nextInt();
		board = new char[R][C];
		visit = new boolean[R][C];
		alphabet = new boolean[26];
		for(int i=0;i<R;i++) {
			String line = sc.next();
			for(int j=0;j<C;j++) {
				board[i][j]=line.charAt(j);
			}
		}

//		int temp = board[0][1]-'A';
//		System.out.println(temp);
		dfs(0,0,1);
		System.out.println(answer);
	}



	private static void dfs(int x, int y, int count) {
		// TODO Auto-generated method stub
		visit[x][y]=true;
		int temp = board[x][y]-'A';
		alphabet[temp]=true;
		
		if(answer<count)
			answer = count;
		
		for(int i=0;i<4;i++) {
			int nextX = x+dir[i][0];
			int nextY = y+dir[i][1];
			
			if(nextX>=0&&nextX<R&&nextY>=0&&nextY<C) {
				int a = board[nextX][nextY]-'A';
				if(!visit[nextX][nextY] && !alphabet[a]) {
					dfs(nextX,nextY,count+1);
				}
			}
		}
		
		visit[x][y]=false;
		alphabet[temp]=false;
	}



//	private static void print() {
//		// TODO Auto-generated method stub
//		for(int i=0;i<R;i++) {
//			System.out.println();
//			for(int j=0;j<C;j++) {
//				System.out.print(board[i][j]);
//			}
//		}
//	}

}
