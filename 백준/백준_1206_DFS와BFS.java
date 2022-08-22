package com.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RE {
	static int N;
	static int M;
	static int V;
	static int[][] map;
	static boolean[]visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		//dfs
		dfs(V);
		System.out.println();
		
		//bfs
		visit = new boolean[N + 1];
		bfs();
	}


	private static void bfs() {
		// TODO Auto-generated method stub
		queue.offer(V);
		visit[V]=true;
		System.out.print(V+" ");
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 1; i <= N; i++) {
				if(map[now][i]==1&&visit[i]==false) {
					queue.add(i);
					visit[i]=true;
					System.out.print(i+" ");
				}
			}
		}
		
		
	}


	private static void dfs(int v) {
		// TODO Auto-generated method stub
		visit[v] = true;
		System.out.print(v+" ");
		for (int i = 1; i <= N; i++) {
			if(map[v][i]==1&&visit[i]==false) {
				dfs(i);
			}
		}
	}

}

