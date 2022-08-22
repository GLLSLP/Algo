package com.jaegui;

import java.io.IOException;
import java.util.Scanner;

public class Hanoi {
	static int count;
	public static StringBuilder sb =new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoi(1,2,3,N);
		System.out.println(count);
		System.out.println(sb);
	}
	private static void hanoi(int a, int b, int c, int disk) {
		count++;
		if(disk==1) {
			sb.append(a+" "+c+" "+"\n");
			return;
		}else if(disk>1) {
			hanoi(a,c,b,disk-1);
			sb.append(a+" "+c+" "+"\n");
			hanoi(b,a,c,disk-1);
		}
	}
}