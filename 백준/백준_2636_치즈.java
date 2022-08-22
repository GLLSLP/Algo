package com.cheese2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };// 우하서북
//	static Queue<Node> queue = new LinkedList<Node>();
	static boolean[][] visit;
	static int sec, count;
	static int r,c;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R + 2][C + 2];
		visit = new boolean[R + 2][C + 2];
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (count()>0) {
			visit = new boolean[R + 2][C + 2];	//필수
			dfs(r, c);
			clear();
			sec++;
		}
		System.out.println(sec);
		System.out.println(count);
	}

	private static int count() {
		int c=0;
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (map[i][j] == 1) {
					c++;
				}
			}
		}
		if(c!=0) {
			count=c;
		}
		return c;
	}

	private static void clear() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1) {
					map[i][j] = 0;
				}
			}
		}
	}

	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y]=true;
		for (int i = 0; i < 4; i++) { // 주변을 봐서
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];
			// 범위안에있고
			if (nextX < 0 || nextX > R || nextY < 0 || nextY > C) {
				continue;
			}
			//방문한적없고
			if(visit[nextX][nextY] == true) {
				continue;
			}
			
			// 치즈가 있으면
			if (map[nextX][nextY] == 1) {
				map[nextX][nextY] = -1; // 치즈에 -1
			}else if (map[nextX][nextY] == 0) { // 공기가 있으면
				dfs(nextX,nextY);
			}
		}
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= R; i++) {
			System.out.println();
			for (int j = 0; j <= C; j++) {
				System.out.print(map[i][j] + "     ");
			}
		}
	}

}

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}