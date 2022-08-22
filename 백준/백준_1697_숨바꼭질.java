package com.hidenseek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int K;

	static int map[];
	static int move[] = { -1, 1, 2 };
	static boolean visited[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		map = new int[100001];
		visited = new boolean[100001];

		bfs();

		System.out.println(map[K]);
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();

		visited[N] = true;
		queue.offer(N);

		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int i = 0; i < 3; i++) {
				int nextX;
				if (i == 2) {
					nextX = x * move[i];
				} else {
					nextX = x + move[i];
				}

				if (nextX >= 0 && nextX <= 100000 && !visited[nextX]) {
					map[nextX] = map[x] + 1;
					
					queue.offer(nextX);
					visited[nextX] = true;
				}
			}
		}
	}

}
