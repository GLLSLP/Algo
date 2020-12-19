package com.island;

import java.util.Scanner;

public class Main {
	static int[][] island;
	static boolean[][] visit;
	static int N;
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, -1, 1, 1, -1 };
	static int count;
	static int n, danji = 1;
	static int W = -1;
	static int H = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();
			if(W==0&&H==0) {
				break;
			}
			island = new int[H][W];
			visit = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					island[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (visit[i][j] == false && island[i][j] == 1) { // 방문한적 없음+아파트 있음
						dfs(i, j); // 탐색시작
						// 한 단지 탐색 끝나면
						danji++; // 단지 수+1
					}
				}
			}
			// 단지수 출력
			if (W != 0 && H != 0)
				System.out.println(danji - 1);
			danji = 1;
			W = -1;
			H = -1;
		}
	}

	private static void dfs(int i, int j) {
		// TODO Auto-generated method stub
		int nextX;
		int nextY;
		island[i][j] = danji; // 현재 방문한 아파트에 번호 넣고 방문true함.
		visit[i][j] = true; // visit때문에 1단지 아파트와 그냥 아파트있음이 구별된다.
		for (int a = 0; a < 8; a++) { // 상하좌우탐색
			nextX = j + dx[a];
			nextY = i + dy[a];
			if (nextX >= 0 && nextX < W && nextY >= 0 && nextY < H) {
				if (island[nextY][nextX] != 0 && visit[nextY][nextX] == false) { // 해당 칸에 아파트가 있고 온적 없으면 진행
					dfs(nextY, nextX);
				}
			}
		}
	}

}
