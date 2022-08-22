import java.util.Scanner;

public class 백준_1016_제곱ㄴㄴ수 {
	static long min, max;
	static boolean[] check = new boolean[1000001];
	public static void main(String[] arg) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		min = sc.nextLong();
		max = sc.nextLong();
		isAbsNoNo();
	}

	private static void isAbsNoNo() {
		// TODO Auto-generated method stub
		int end = (int) Math.sqrt(max);
		for (long i = 2; i <= end; i++) {
			long start = ((min - 1) / (i * i) + 1) * (i * i);
			for (long a = start; a <= max; a += (i * i)) {
				check[(int) (a - min)] = true;
			}
		}
		int count = 0;
		for (int i = 0; i < (max - min + 1); i++) {
			count += (check[i] == true) ? 1 : 0;
		}
		System.out.print(max - min - count + 1);
	}
}
