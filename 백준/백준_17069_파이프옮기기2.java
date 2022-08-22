package com.pipe;

import java.io.*;
import java.util.*;

public class Main2 {

	static int size;
	static long result = 0;
	static int[] dx = { 0, 1, 1 }; // 가로, 세로, 대각선
	static int[] dy = { 1, 0, 1 };
	static int[][] map;
	static long[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		size = stoi(st.nextToken());

		map = new int[size][size];
		dp = new long[size][size][3];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		} // 인풋 종료
		dp[0][1][0] = 1;
		dynamic();
//		print();
		for (int i = 0; i < 3; i++) {
			result += dp[size - 1][size - 1][i];
		}
		System.out.println(result);

	}

	private static void dynamic() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < 3; k++) {
					if (dp[i][j][k] > 0) {
						for (int l = 0; l < 3; l++) {
							if (k == 0 && l == 1) {
								continue;
							} else if (k == 1 && l == 0) {
								continue;
							}
							if (isPossible(i, j, l)) {
								dp[i + dx[l]][j + dy[l]][l] += dp[i][j][k];
							}
						}

					}
				}
			}
		}
	}

	private static boolean isPossible(int x, int y, int type) {
		int nx = x + dx[type];
		int ny = y + dy[type];

		if (nx >= size || ny >= size)
			return false;

		if (type != 2) {
			if (map[nx][ny] == 0) {
				return true;
			}
		} else {
			if (map[nx][ny] == 0 && map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
				return true;
			}
		}
		return false;
	}

	private static void print() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.format("%2d ", dp[i][j][0] + dp[i][j][1] + dp[i][j][2]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}