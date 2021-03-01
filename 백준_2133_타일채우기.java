import java.util.Scanner;

public class 백준_2133_타일채우기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[0] = 1;
		if (N % 2 == 1) {// 홀수일땐 0
			System.out.println(0);
		} else if (N == 2) {
			System.out.println(3);
		} else if (N >= 4) {
			dp[2] = 3;
			for (int n = 4; n <= N; n += 2) {
				dp[n] = dp[n - 2] * 3;
				for (int m = 4; n - m >= 0; m += 2) {// 짝수번 고유의 모양을 오른쪽에 붙인거 더하기
					dp[n] += dp[n - m] * 2;// 오른쪽벽에 붙이니까 그전(n-m)까지의 수 * 고유모양 수(2)
				}
			}
			System.out.println(dp[N]);
		}

	}

}
