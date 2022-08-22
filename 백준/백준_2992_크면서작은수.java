import java.util.Scanner;

public class 백준_2992_크면서작은수 {
	static int X, N, answer = 999999;
	static int[] ori;
	static int[] num;
	static boolean[] isSelected;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();// 원형
		String line = Integer.toString(X);// 쪼갤거
		N = line.length();// 자리수의개수
		ori = new int[N];
		for (int i = 0; i < line.length(); i++) {
			ori[i] = line.charAt(i) - '0';
		}
		num = new int[N];
		isSelected = new boolean[N];
		perm(0);
		if (answer == 999999) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
	}

	private static void perm(int c) {
		// TODO Auto-generated method stub
		if (c == N) {
			String com = "";
			for (int i = 0; i < N; i++) {
				com += Integer.toString(num[i]);
			}
			if (Integer.parseInt(com) > X) {
				answer = Math.min(answer, Integer.parseInt(com));
			}

			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				continue;
			}

			isSelected[i] = true;
			num[c] = ori[i];
			perm(c + 1);
			isSelected[i] = false;
		}

	}

}
