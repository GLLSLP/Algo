import java.util.Scanner;

public class 백준_2579_계단오르기 {
	static int N;
	static int[] stair;
	static int[] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		stair = new int[N + 1];
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stair[i] = sc.nextInt();
		}
		go();

		System.out.println(dp[N]);

	}

	private static void go() {
		dp[0] = 0;
		dp[1] = stair[1];
		if (N == 2) {
			dp[2] = stair[1] + stair[2];
			return;
		} else if (N >= 3) {
			dp[2] = stair[1] + stair[2];
			for (int i = 3; i <= N; i++) {
				dp[i] = Math.max(stair[i] + dp[i - 2], stair[i] + stair[i - 1] + dp[i - 3]);
			}
		}

	}

}
