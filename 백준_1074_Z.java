package com.jaegui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
	static int N;
	static int r;
	static int c;
	static int count;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, N);
		int[][] square = new int[size][size];
		search(0, 0, getSize(N));
	}

	private static void search(int a, int b, int size) {
		// TODO Auto-generated method stub
		if (size == 1) { 
			if (a == r && b == c) {
				System.out.println(count);
			}
			count++;
			return;
		}
		int s = size / 2;
		search(a, b, s);		//
		search(a, b + s, s);	//오른쪽
		search(a + s, b, s);	//아래
		search(a + s, b + s, s);//오른쪽아래
	}

	static int getSize(int n) {
		int result = 1;
		for (int i = 0; i < n; i++)
			result *= 2;
		return result;
	}

}
