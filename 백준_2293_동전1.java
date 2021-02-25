import java.util.Scanner;

public class 백준_2293_동전1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N + 1];
		for (int n = 0; n < N; n++) {
			coin[n] = sc.nextInt();
		}
		int[] dp = new int[K + 1];
		dp[0] = 1;
		for (int n = 0; n < N; n++) {
			for (int k = coin[n]; k <= K; k++) {
				dp[k] += dp[k - coin[n]];
			}
		}
		System.out.println(dp[K]);
	}

}
