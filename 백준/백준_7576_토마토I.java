package com.tomato;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RE {
	// 익은 토마토가 있는곳의 좌표를 저장
	static Queue<Dot> queue = new LinkedList<>();
	// 왼쪽에서부터 남북동서
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	// 토마토들 저장하는 2차원 배열
	static int[][] tomato;
	static int M;
	static int N;
	static int H;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();	//가로
		N = sc.nextInt();	//세로
		tomato = new int[N][M];	//토마토 판
		
		//토마토판에 토마토들의 상태를 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tomato[i][j] = sc.nextInt();
				if (tomato[i][j] == 1) {
					queue.add(new Dot(j, i));
				}
			}
		}
		
		//탐색시작
		bfs();
		
		//정답출력
		System.out.println(findMax());
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			//큐에서 익은 토마토 좌표 하나 꺼냄
			Dot now = queue.poll();
			
			//4방탐색 시작
			for (int i = 0; i < 4; i++) {
				//이동할수 있는 토마토 판의 X,Y좌표(nextX,nextY)는 현재 토마토 판의 좌표인 now.x,now.y에서 동서남북 방향이다.
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				//만약 다음에 이동할 위치가 토마토 판에서 벗어난 곳이면
				if (nextX < 0 || nextX > M - 1 || nextY < 0 || nextY > N - 1) { 
					//이번 좌표는 스킵
					continue;
				}
				//만약 다음에 이동할 위치의 토마토가 익었거나, 토마토가 없는곳이면
				if (tomato[nextY][nextX] != 0) {
					//이번 좌표는 스킵
					continue;
				}
				//위의 if문 2개에서 모두 걸리지 않은 nextX,nextY는 다음 탐색에 적합하다.
				tomato[nextY][nextX] = tomato[now.y][now.x] + 1;	//토마토 문제에서만 나오는것...몇일이 지났는지를 세기 위함
				//따라서 익은 토마토 좌표에 추가해 탐색을 이어나갈수 있게 한다.
				queue.add(new Dot(nextX, nextY));
			}

		}
	}
	
	//탐색이 끝난 후 토마토 판에 저장된 숫자들은 그 토마토가 몇일만에 익었는지를 나타내므로 가장 큰 수를 찾으면 토마토가 모두 익기까지의 날짜를 알 수 있다.
	public static int findMax() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) { // 토마토가 모두 익지 못하는 상황
					return -1;
				}

				max = Math.max(max, tomato[i][j]);
			}

		}
		return (max - 1);
	}

	// 큐에 저장할 좌표
	static class Dot {
		int x;
		int y;

		Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
