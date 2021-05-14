import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[0] = 2;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			if (dp[i - 1] == 1) {
				dp[i] = 2;
			} else {
				dp[i] = 1;
			}
			if (i - 3 < 0) {
				continue;
			}
			if (dp[i - 3] == 1) {
				dp[i] = 2;
			} else {
				dp[i] = 1;
			}
		}
		if (dp[N] == 2) {
			System.out.println("SK");
		} else if (dp[N] == 1) {
			System.out.println("CY");
		}
	}

}
