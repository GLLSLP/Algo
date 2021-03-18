import java.util.Scanner;

public class 백준_11726_2xn타일링 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		if (N > 1) {
			for (int i = 2; i <= N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
			}
		}
		System.out.println(dp[N]);
	}

}
