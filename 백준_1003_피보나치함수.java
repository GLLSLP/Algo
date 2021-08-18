import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		int[][] dp = new int[41][2];
		dp[0][0] = 1;
		dp[1][0] = 0;

		dp[0][1] = 0;
		dp[1][1] = 1;

		for (int d = 2; d <= 40; d++) {
			dp[d][0] = dp[d - 1][0] + dp[d - 2][0];
			dp[d][1] = dp[d - 1][1] + dp[d - 2][1];
		}

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0) {
				bw.write("1 0\n");
				continue;
			} else if (N == 1) {
				bw.write("0 1\n");
				continue;
			}

			bw.write(Integer.toString(dp[N][0]) + " " + Integer.toString(dp[N][1]) + "\n");

		}
		bw.flush();
		bw.close();
	}

}
