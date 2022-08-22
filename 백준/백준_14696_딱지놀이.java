package com.ddakji14696;

import java.util.Scanner;

public class Main {
	static int ground;
	static int[] acard;
	static int[] bcard;

	// 1 2 3 4... 세모 네모 동그라미 별
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ground = sc.nextInt();
		for (int i = 0; i < ground; i++) {
			acard = new int[5];
			bcard = new int[5];
			int atotal = sc.nextInt();
			for (int j = 0; j < atotal; j++) {
				int temp = sc.nextInt();
				acard[temp]++;
			}
			int btotal = sc.nextInt();
			for (int j = 0; j < btotal; j++) {
				int temp = sc.nextInt();
				bcard[temp]++;
			}

			//판정
			if(acard[4]!=bcard[4]) {
				if(acard[4]>bcard[4]) {
					System.out.println("A");
				}else {
					System.out.println("B");
				}
			}else if(acard[4]==bcard[4]&&acard[3]!=bcard[3]) {
				if(acard[3]>bcard[3]) {
					System.out.println("A");
				}else {
					System.out.println("B");
				}
			}else if(acard[4]==bcard[4]&&acard[3]==bcard[3]&&acard[2]!=bcard[2]) {
				if(acard[2]>bcard[2]) {
					System.out.println("A");
				}else {
					System.out.println("B");
				}
			}else if(acard[4]==bcard[4]&&acard[3]==bcard[3]&&acard[2]==bcard[2]&&acard[1]!=bcard[1]) {
				if(acard[1]>bcard[1]) {
					System.out.println("A");
				}else {
					System.out.println("B");
				}
			}else {
				System.out.println("D");
			}
		}
	}

}
