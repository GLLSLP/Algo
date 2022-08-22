import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S = br.readLine();
		int N = Integer.parseInt(br.readLine());
		String[] word = new String[N];
		for (int n = 0; n < N; n++) {
			String line = br.readLine();
			word[n] = line;
		}

		int[] dp = new int[S.length() + 1];
		dp[0] = 1;
		for (int i = 0; i < S.length(); i++) {
			if (dp[i] == 0) {
				continue;
			}
			for (int n = 0; n < N; n++) {
				int wordLen = word[n].length();
				int end = i + wordLen;
				if (end > S.length()) {
					continue;
				}
				String parts = S.substring(i, end);
				if (parts.equals(word[n])) {
					dp[end] = 1;

				}
			}
		}

		bw.write(Integer.toString(dp[S.length()]));
		bw.flush();
		bw.close();
	}
}
