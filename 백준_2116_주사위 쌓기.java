package com.dice;

import java.util.Scanner;

public class Main {

	static int n;
	static int[][] dice;
	static int answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();	//주사위개수
		dice = new int[n+1][6];//주사위 1~5번, 알파벳인덱스 0~5번.
		for (int i = 1; i <= n; i++) {
			dice[i][0] = sc.nextInt();
			dice[i][1] = sc.nextInt();
			dice[i][2] = sc.nextInt();
			dice[i][3] = sc.nextInt();
			dice[i][4] = sc.nextInt();
			dice[i][5] = sc.nextInt();
		}
		System.out.println(dice[5][5]);
		for (int i = 0; i < 6; i++) {
			int bottom = dice[1][i];
			System.out.println("스타트"+i);
			go(bottom, i, 0, 1);
			System.out.println("합계"+answer);
		}
		
	}

	//현재 바닥숫자, 현재 바닥숫자 인덱스, 현재까지 합계 , 현재 주사위번호
	private static void go(int bottomNum, int bottomIndex, int sum, int diceNum) {
		// TODO Auto-generated method stub
		int opposideIndex=-1;	//반대편 인덱스 구하기
		if(bottomIndex==0) {
			opposideIndex=5;
		}else if(bottomIndex==1) {
			opposideIndex=3;
		}else if(bottomIndex==2) {
			opposideIndex=4;
		}else if(bottomIndex==3) {
			opposideIndex=1;
		}else if(bottomIndex==4) {
			opposideIndex=2;
		}else if(bottomIndex==5) {
			opposideIndex=0;
		}
		System.out.println("현재"+diceNum+"번 주사위 사용중..");
		System.out.println("현재 바닥은"+bottomNum+"이고 위 인덱스는"+opposideIndex+"입니다."+diceNum);
		int temp=0;
		//내 주사위 최대값 찾기
		for (int i = 0; i < 6; i++) {
			if(i==bottomIndex || i==opposideIndex) {
				continue;
			}else {
				temp = Math.max(temp, dice[diceNum][i]);
			}
		}
		sum += temp;	//내주사위 최대값
		
//		System.out.println("temp"+temp);
		
		
		//지금 마지막주사위면 끝
		if(diceNum==5) {
//			System.out.println("더하나?");
			answer = Math.max(answer, sum);
//			System.out.println("답"+answer);
			return;
		}else if(diceNum<=4){
			for (int i = 0; i <= 5; i++) {
				System.out.println("주삿"+diceNum);
				if(dice[diceNum][opposideIndex]==dice[diceNum+1][i]) {
					go(dice[diceNum][opposideIndex], i, sum, ++diceNum);
				}
			}
		}
		
		
		
		
	}

}
