import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[101][10];
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		int answer = 0;
		for (int i = 2; i <= 100; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j + 1];
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			answer = (answer + dp[N][i]) % 1000000000;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
}
