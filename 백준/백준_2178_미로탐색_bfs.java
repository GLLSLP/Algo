package com.maze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] maze;
	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
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
		bfs();
		
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(0,0,1));
		maze[0][0]=2;
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			int nowX=now.x;
			int nowY=now.y;
			int move=now.m;
			if(nowX==N-1&&nowY==M-1) {
				System.out.println(move);
				return;
			}
			int fail=0;
			for (int i = 0; i < 4; i++) {
				int nextX=nowX+dir[i][0];
				int nextY=nowY+dir[i][1];
				if(nextX>=0&&nextX<N&&nextY>=0&&nextY<M) {
					if(maze[nextX][nextY]==1) {
						maze[nextX][nextY]=2;
						queue.offer(new Node(nextX,nextY, move+1));
					}
				}
			}
		}
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j <M; j++) {
				System.out.print(maze[i][j]);
			}
		}
	}


}

class Node{
	int x;
	int y;
	int m;
	public Node(int x, int y, int m) {
		this.x = x;
		this.y = y;
		this.m = m;
	}
	
}
