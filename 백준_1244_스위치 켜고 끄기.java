package com.switch1244;

import java.util.Scanner;

public class Main {
	static int num;
	static int[] swit;
	static int stnum;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		swit = new int[num+1];
		for (int i = 1; i <= num; i++) {
			swit[i] = sc.nextInt();
		}

		stnum = sc.nextInt();
		for (int i = 0; i < stnum; i++) {
			int gender = sc.nextInt();
			int number = sc.nextInt();
			if (gender == 1) {
				male(number);
			} else if (gender == 2) {
				female(number);
			}
		}

		print();
	}

	private static void female(int n) {
		// TODO Auto-generated method stub
//		System.out.println("여성");
//		System.out.println(target);
		for (int i = 0; i <= num; i++) {
			if (((n + i) <= num) && ((n - i) >= 1)) {	//양옆에 범위안에 있고
				if (swit[n + i] == swit[n - i]) {	//같으면
//					System.out.println(n+i+","+(n-i)+"인덱스꺼 바꿈");
					if (swit[n + i] == 1) {
						swit[n + i] = 0;
						swit[n - i] = 0;
					} else{
						swit[n + i] = 1;
						swit[n - i] = 1;
					}
				} else {	//같지않으면
					return;	//끝
				}
			} else {	//범위밖이면
				return;	//끝
			}
		}

//		print();
	}

	private static void male(int n) {
		// TODO Auto-generated method stub
//		System.out.println("남성");
		for (int i = 1; i <= num; i++) {
			int target = n * i;
			if (target <= num) {
//				System.out.println(target+"바꿈");
				if (swit[target] == 1) {
					swit[target] = 0;
				}else{
					swit[target] = 1;
				}
			} else {
//				print();
				return;
			}
		}
		
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= num; i++) {
			if (i == 21 || i == 41 || i == 61 || i == 81) {
				System.out.println();
			}
			System.out.print(swit[i] + " ");
		}
	}

}
