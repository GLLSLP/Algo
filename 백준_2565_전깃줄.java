import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][2];
		int[] dp = new int[N + 1];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[n][0] = a;
			arr[n][1] = b;

		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		dp[1] = 1;
		int max = 0;
		for (int n = 2; n <= N; n++) {
			for (int m = 0; m < n; m++) {
				if (arr[m][1] < arr[n][1] && dp[n] <= dp[m]) {
					dp[n] = dp[m] + 1;
					max = Math.max(max, dp[n]);
				}
			}
		}

		bw.write(Integer.toString(N-max));

		bw.flush();
		bw.close();
	}
}
