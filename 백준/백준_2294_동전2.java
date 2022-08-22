import java.util.Scanner;

public class 백준_2294_동전2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N];
		int[] dp = new int[K + 1];
		for (int n = 0; n < N; n++) {
			coin[n] = sc.nextInt();
		}
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 100001;
		}

		for (int c = 0; c < coin.length; c++) {
			for (int d = coin[c]; d <= K; d++) {// 가장 작은 동전부터
				dp[d] = Math.min(dp[d], dp[d - coin[c]] + 1);
			}
		}
		if (dp[K] == 100001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[K]);
		}
	}

}
