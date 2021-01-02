package com.gmpg;

import java.util.Arrays;
import java.util.Scanner;

public class Danji {
	static int[][] apt;
	static boolean[][] visit;
	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int count;
	static int danji = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		apt = new int[N + 1][N + 1];
		visit = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < N; i++) {
			String line = sc.next(); // nextLine으로x
			for (int j = 0; j < line.length(); j++) {
				apt[i][j] = line.charAt(j) - 48;
			}
		} // for i
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == false && apt[i][j] == 1) {	//방문한적 없음+아파트 있음
					dfs(i, j);	//탐색시작
					//한 단지 탐색 끝나면
					danji++;	//단지 수+1
				}
			}
		} // for i
		
		//단지수 출력
		System.out.println(danji - 1);
		//각 단지의 집 수를 저장
		int arr[] = new int[danji];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (apt[i][j] != 0) {	//0보다 크면서
					arr[apt[i][j]]++;	//같은 번호를 가진 단지끼리는 같은 arr[i]에 집 수 +함.
				}
			}
		}
		Arrays.sort(arr);	//오름차순 정렬
		for(int i=1;i<arr.length;i++) {	//단지 번호가 1부터 시작해 arr도 1로 시작한다.
			System.out.println(arr[i]);	//단지는 처음부터 1로 시작하므로 3개의 단지가 있으면 danji는 4라서 arr도 4크기만큼 되어있다.
		}
	}

	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		int nextX;
		int nextY;
		apt[x][y] = danji;	//현재 방문한 아파트에 번호 넣고 방문true함. 
		visit[x][y] = true;	//visit때문에 1단지 아파트와 그냥 아파트있음이 구별된다.
		for (int i = 0; i < 4; i++) {	//상하좌우탐색
			nextX = x + dx[i];
			nextY = y + dy[i];
			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
				if (apt[nextX][nextY] != 0 && visit[nextX][nextY] == false) { // 해당 칸에 아파트가 있고 온적 없으면 진행
					dfs(nextX, nextY);
				}
			}
		}
	}// dfs
}