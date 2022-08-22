package com.number2635;

import java.util.Scanner;

public class Main {
	static int num;
	static int answer;
	static int second;
	static int max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
		
		for (int i = num; i >= num/2; i--) {
			find(num,i,0);
			if(max>answer) {
				answer = max;
				second=i;
			}
		}
//		System.out.println((answer+1)+","+second);
		printanswer();
	}

	private static void printanswer() {
		// TODO Auto-generated method stub
		System.out.println(answer+1);
		int now = num;
		int next = second;
		for (int i = 0; i <= answer; i++) {
			System.out.print(now+" ");
			int temp = now-next;
			now =next;
			next=temp;
		}
	}

	private static void find(int now, int next, int count) {
		// TODO Auto-generated method stub
		count++;
		if(now-next>=0) {
			find(next,now-next,count);
		}else {
			max=count;
			return;
		}
		
	}

}
