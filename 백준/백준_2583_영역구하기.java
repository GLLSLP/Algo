import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 백준_2583_영역구하기 {
	static int R,C,K;
	static int[][]map;
	static boolean[][]visit;
	static int [][]dir= {{0,1},{1,0},{0,-1},{-1,0}};
	static int count;
	static int area; //초기화
	static ArrayList<Integer> areas; //넓이저장용
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		K=sc.nextInt();
		map=new int[R][C];
		visit=new boolean[R][C];
		areas = new ArrayList<>();


		for (int k = 0; k < K; k++) {
			int leftC=sc.nextInt();
			int leftR=sc.nextInt();
			int rightC=sc.nextInt();
			int rightR=sc.nextInt();
			color(leftC,leftR,rightC,rightR);
		}
//		print();
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(visit[r][c]==false && map[r][c]==0) {
					area = 0;
					dfs(r,c);//탐색시작
					count++;
					areas.add(area);
				}
			}
		}
		Collections.sort(areas);

		System.out.println(count);
		for(int i : areas) {
		      System.out.print(i + " ");
		}

	}
	private static void dfs(int r, int c) {
		// TODO Auto-generated method stub
		visit[r][c]=true;
		area++;
		for (int i = 0; i < 4; i++) {
			int nextX=r+dir[i][0];
			int nextY=c+dir[i][1];
			if(nextX>=0 && nextX<R && nextY>=0 && nextY<C) {
				if(map[nextX][nextY]==0 && visit[nextX][nextY]==false) {
					dfs(nextX,nextY);
				}
			}
		}
	}
	private static void print() {
		// TODO Auto-generated method stub
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(visit[r][c]) {
					System.out.print(1);
				}else {
					System.out.print(0);
				}
			}
			System.out.println();
		}
	}
	private static void color(int leftC, int leftR, int rightC, int rightR) {
		// TODO Auto-generated method stub
		for (int r = leftR; r < rightR; r++) {
			for (int c = leftC; c < rightC; c++) {
				map[r][c]=1;//막힌곳이 1
			}
		}
	}


}
