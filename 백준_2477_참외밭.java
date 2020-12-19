package com.melon2477;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int H, W;
	static int[][] input;
	static int minH, minW;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		input = new int[8][2];
		for (int i = 1; i <= 6; i++) {	//인덱스 1~6
			input[i][0] = sc.nextInt(); // 방향
			input[i][1] = sc.nextInt(); // 길이
			if (input[i][0] == 1 || input[i][0] == 2) {
				W = Math.max(input[i][1], W); // 최대 가로길이
			}
			if (input[i][0] == 3 || input[i][0] == 4) {
				H = Math.max(input[i][1], H); // 최대 세로길이
			}
		}
		input[0][0]=input[6][0];
		input[0][1]=input[6][1];
		input[7][0]=input[1][0];
		input[7][1]=input[1][1];
	
		
		for (int i = 1; i <= 6; i++) {
			if (input[i][0] == 1 || input[i][0] == 2) {// 가로에서
				// 양옆의 변의 길이가 최대세로랑 같으면 내가 범인
				int left = input[i - 1][1];
				int right = input[i + 1][1];
				if(left+right==H) {
					minW=input[i][1];
				}
			}
			if (input[i][0] == 3 || input[i][0] == 4) {// 가로에서
				// 양옆의 변의 길이가 최대세로랑 같으면 내가 범인
				int left = input[i - 1][1];
				int right = input[i + 1][1];
				if(left+right==W) {
					minH=input[i][1];
				}
			}
		}
		
		int answer = (H*W-minH*minW)*n;
		System.out.println(answer);

	}

}
