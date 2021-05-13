import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1788_피보나치수의확장 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1000001];
		dp[0] = 0;
		dp[1] = 1;
		if (N == 0) {
			System.out.println(0);
			System.out.println(0);
		} else if (N == 1) {
			System.out.println(1);
			System.out.println(1);
		} else {
			int num = Math.abs(N);
			for (int i = 2; i <= num; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
			}
			if (N < 0 && num % 2 == 0) {
				System.out.println(-1);
			} else {
				System.out.println(1);
			}
			System.out.println(dp[num]);
		}

	}

}
