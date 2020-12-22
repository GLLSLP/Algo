package com.snowwhite;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] dwarf;
	static int[] choice;
	static int[] answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		dwarf = new int[9];
		choice = new int[7];
		answer = new int[7];
		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
		}
		
		combination(0,0);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	private static void combination(int count, int current) {
		// TODO Auto-generated method stub
		if(count==7) {	//선별 완료
			int total=0;
			for (int i = 0; i < choice.length; i++) {
				total += choice[i];
			}
			if(total==100) {
				Arrays.sort(choice);
				for (int i = 0; i < choice.length; i++) {
					answer[i] = choice[i];
				}
			}
			return;
		}
		for (int i = current; i < 9; i++) {
			choice[count] = dwarf[i];
			combination(count+1,i+1);
		}
	}

}
