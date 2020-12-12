package com.quadtree;

import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static int mv[][];
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		mv = new int[N][N];
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < N; j++) {
				mv[i][j] = line.charAt(j) - '0';

			}
		}

		compress(N, 0, 0);

		System.out.println(sb.toString());

	}

	private static void compress(int n, int j, int i) {
		// TODO Auto-generated method stub
		int start = mv[j][i];
		boolean flag = false;
		for (int a = j; a < j+n; a++) {
			if (flag == true) { // 만약 다 같지 않으면
				break;
			}
			for (int b = i; b < i+n; b++) {
				if (start != mv[a][b]) {
					flag = true;
					break;
				}
			}
		}
		if (flag == false) { // 만약 다 같으면
			sb.append(start);
			return;
		} else { // 다 같지 않을경우엔
			n = n / 2; // 4등분 시작함
			int[][]dir = {{0,0},{0,1},{1,0},{1,1}};
			sb.append("(");
			for(int d = 0;d<4;d++) {
				compress(n, j+n*dir[d][0], i+n*dir[d][1]);
			}
			sb.append(")");
		}

	}

}
