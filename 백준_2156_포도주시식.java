import java.util.Scanner;

public class 백준_2156_포도주시식 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] wine = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			wine[n] = sc.nextInt();
		}
		int[] dp = new int[N + 1];
		if (N == 1) {
			System.out.println(wine[1]);
		} else if (N == 2) {
			System.out.println(wine[1] + wine[2]);
		} else {
			dp[1] = wine[1];
			dp[2] = wine[1] + wine[2];
			for (int i = 3; i <= N; i++) {
				dp[i] = Math.max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]);
				dp[i] = Math.max(dp[i - 1], dp[i]);
			}
			System.out.println(dp[N]);
		}

	}

}
