package com.square2527;

import java.util.Scanner;

public class Main {
	static int x,y,p,q,x2,y2,p2,q2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			char answer = 'z';
			x=sc.nextInt();
			y=sc.nextInt();
			p=sc.nextInt();
			q=sc.nextInt();
			x2=sc.nextInt();
			y2=sc.nextInt();
			p2=sc.nextInt();
			q2=sc.nextInt();	
			if((x>p2||x2>p)||(y>q2)||(q<y2)) {
				answer='d';
			}else if((x==p2||x2==p)&&(y==q2)||(q==y2)) {
				answer='c';
			}else if((x==p2||x2==p)||(y==q2)||(q==y2)) {
				answer='b';
			}else {
				answer='a';
			}
				
			System.out.println(answer);
		}
	}

}
