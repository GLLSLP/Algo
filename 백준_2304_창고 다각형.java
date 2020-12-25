package com.storagePoly2304;

import java.util.Scanner;

public class Answer {
	static int N;
	static int[] pillar; //기둥위치
	static int max_H; //가장 높은 기둥
	static int max_idx; //가장 높은 기둥 위치
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		pillar = new int[1001];//최대크기 선언
		
		max_H = 0;
		max_idx = -1;
		
		for(int i = 0 ; i<N; i++) {
			int idx = sc.nextInt();
			int height = sc.nextInt();
			pillar[idx] = height;
			//입력 받으면서 높은 기둥 갱신
			if(max_H < height) {
				max_H = height;
				max_idx = idx;
			}
		}
		int ans = 0;
		int curr_H = 0;
		
		//왼쪽끝에서 높은 기둥까지의 면적
		for(int i = 0 ; i<=max_idx; i++) {
			if (pillar[i]>curr_H)
				curr_H = pillar[i];
			ans += curr_H;
		}
		
		//오른쪽 끝에서 높은 기둥까지의 면적
		curr_H = 0;
		for(int i = 1000; i>max_idx; i--) {
			if(pillar[i] > curr_H)
				curr_H = pillar[i];
			ans+=curr_H;
		}
		
		System.out.println(ans);
	}
}
