import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_16500_문자열판별 {
	static String[] word;
	static boolean[] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(br.readLine());
		dp = new boolean[line.length() + 1];
		word = new String[N];
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}

		dp[0] = true;
		for (int i = 0; i < line.length(); i++) {
			int len = i + 1;
			for (int n = 0; n < N; n++) {
				if (len >= word[n].length()) {
					if (line.substring(len - word[n].length(), len).equals(word[n])) {
						if (dp[len - word[n].length()]) {
							dp[len] = true;
							break;
						}
					}
				}
			}
		}
		if (dp[line.length()]) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
