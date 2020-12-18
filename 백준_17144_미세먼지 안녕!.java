package com.air;

import java.util.Scanner;

public class Main {
	static int[][] room;
	static int[][] temp;
	static int R;
	static int C;
	static int T;
	static int answer;
	static int ax;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		room = new int[R + 1][C + 1];
		temp = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				room[i][j] = sc.nextInt();
				if (room[i][j] == -1) {
					ax = i;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			dust();// 먼지확산
			clear();// 공기청정기 가동
		}

		ans();
		System.out.println(answer);
	}

	private static void clear() {
		// TODO Auto-generated method stub
		int upX = ax - 1;
		int downX = ax;
		// 위
		for (int i = upX - 1; i > 1; i--) {
			room[i][1] = room[i - 1][1];
		}
		for (int i = 1; i < C; i++) {
			room[1][i] = room[1][i + 1];
		}
		for (int i = 1; i < upX; i++) {
			room[i][C] = room[i + 1][C];
		}
		for (int i = 8; i > 2; i--) {
			room[upX][i] = room[upX][i - 1];
		}
		room[upX][2] = 0;
//		print();
//		System.out.println();

		// 아래
		for (int i = downX + 1; i < R; i++) {
			room[i][1] = room[i + 1][1];
		}
		for (int i = 1; i < C; i++) {
			room[R][i] = room[R][i + 1];
		}
		for (int i = R; i > downX; i--) {
			room[i][C] = room[i - 1][C];
		}
		for (int i = C; i > 2; i--) {
			room[downX][i] = room[downX][i - 1];
		}
		room[downX][2] = 0;

//		print();
//		System.out.println();
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= R; i++) {
			System.out.println();
			for (int j = 1; j <= C; j++) {
				System.out.print(room[i][j] + "\t");
			}
		}
	}

	private static void dust() {
		// TODO Auto-generated method stub
		int temp[][] = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (room[i][j] > 0) {
					int dust = room[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int nextX = i + dir[d][0];
						int nextY = j + dir[d][1];
						if (nextX >= 1 && nextX <= R && nextY >= 1 && nextY <= C && room[nextX][nextY] != -1) {
							temp[nextX][nextY] += dust;
							room[i][j] -= dust;
						}
					}
				}
			}
		}

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				room[i][j] += temp[i][j];
			}
		}

//		print();
//		System.out.println();
	}

	private static void ans() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= R; i++) {
//			System.out.println();
			for (int j = 1; j <= C; j++) {
				if (room[i][j] > 0) {
					answer += room[i][j];
				}
//				System.out.print(room[i][j]);
			}
		}
	}

}
