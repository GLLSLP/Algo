package com.ant10158;

import java.util.Scanner;

public class Main {
	static int w, h, p, q, T;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt(); // x..row
		h = sc.nextInt(); // y...column
		p = sc.nextInt(); // 개미x
		q = sc.nextInt(); // 개미y
		T = sc.nextInt(); // 시간

		//
		int ax = 0;
		int ay = 0;
		int time = T-(w-p);
		if((time/w)%2==1) {
			ax=time%w;
		}else {
			ax=w-(time%w);
		}
		
		time = T-(h-q);
		if((time/h)%2==1) {
			ay=time%h;
		}else {
			ay=h-(time%h);
		}

		System.out.println(ax+" "+ay);
	}
}

