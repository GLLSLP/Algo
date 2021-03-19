import java.util.Scanner;

public class 백준_1016_제곱ㄴㄴ수 {
	static long min, max, answer, root;
	static boolean[] check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		min = sc.nextLong();
		max = sc.nextLong();
		check = new boolean[1000001];
		isAbsNoNo();
		System.out.println(answer);
	}

	private static void isAbsNoNo() {
		// TODO Auto-generated method stub
		root = (long) Math.sqrt(max);
		for (long i = 2; i < root; i++) {
			long s = ((min - 1) / i * i + 1) * (i * i);
			for (long j = s; j < max; j += i * i) {
				check[(int) (j - min)] = true;
			}
		}
		for (int i = 0; i <= max - min; i++) {
			if (check[i]) {
				answer++;
			}
		}
	}

}
