import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		dp[1] = 1;

		if (N >= 2) {
			int max = 0;
			for (int n = 2; n <= N; n++) {
				for (int m = 0; m < n; m++) {
					if (arr[m] < arr[n] && dp[n] <= dp[m]) {
						dp[n] = dp[m] + 1;
						max = Math.max(max, dp[n]);
					}
				}
			}
			dp[N] = Math.max(max, dp[N]);
		}
		bw.write(Integer.toString(dp[N]));
		bw.flush();
		bw.close();
	}
}
