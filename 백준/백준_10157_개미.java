package com.seat10157;

import java.util.Scanner;

public class Main {
	static int C, R;// 가로,세로
	static int seat[][];
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int d = 0;
	static int num=0;
	static int find;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		find=sc.nextInt();	//찾을 번호
		seat = new int[R + 1][C + 1];
//		print();
		rotation(1, 1);
//		print();
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(seat[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void rotation(int x, int y) {
		// TODO Auto-generated method stub
		num++;
		seat[x][y]=num;
		if(num==find) {
			System.out.println(y+" "+x);
			return;
		}else if(find>C*R) {
			System.out.println(0);
			return;
		}
		int nextX=x+dir[d][0];
		int nextY=y+dir[d][1];
		if(nextX>=1&&nextX<=R&&nextY>=1&&nextY<=C) {
			if(seat[nextX][nextY]==0) {
				rotation(nextX,nextY);
			}else {
				if(d==0) {
					d=1;
				}else if(d==1) {
					d=2;
				}else if(d==2) {
					d=3;
				}else if(d==3) {
					d=0;
				}
				nextX=x+dir[d][0];
				nextY=y+dir[d][1];
				rotation(nextX,nextY);
			}
		}else {
//			System.out.println("방향전환");
			if(d==0) {
				d=1;
			}else if(d==1) {
				d=2;
			}else if(d==2) {
				d=3;
			}else if(d==3) {
				d=0;
			}
			nextX=x+dir[d][0];
			nextY=y+dir[d][1];
			rotation(nextX,nextY);
		}

	}

}
