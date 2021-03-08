import java.util.Scanner;

public class 백준_2410_2의멱수의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 2] + dp[i / 2]) % 1000000000;// % 1000000000 없으면 틀림
		}

		System.out.println(dp[N]);
	}

}
