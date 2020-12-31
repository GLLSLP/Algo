package com.virus;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] computer;
	static boolean[] check;
	static boolean[] virus;
	static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		computer = new int[N + 1][N + 1];
		check = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			computer[a][b] = 1;
			computer[b][a] = 1;
		}
		dfs(1);
		System.out.println(count);
	}
	private static void dfs(int v) {
		// TODO Auto-generated method stub
		check[v] = true;
		for (int i = 1; i <= N; i++) {
			if (computer[v][i] == 1 && check[i] == false) {
				count++;
				dfs(i);
			} 

		}
	}

}
