import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_16500_문자열판별 {
	static String line;
	static String[] words;
	static int len;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine();
		int N = Integer.parseInt(br.readLine());
		words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
			len += words[i].length();
		}
		if (dp(0)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static boolean dp(int start) {
		// TODO Auto-generated method stub
		if (start == line.length()) {
			return true;
		}

		for (int i = 0; i < words.length; i++) {
			boolean check = false;
			String word = words[i];

			if (word.length() + start > line.length()) {
				continue;
			}
			for (int j = 0; j < word.length(); j++) {
				if (line.charAt(start + j) != word.charAt(j)) {
					check = true;
					break;
				}
			}
			if (!check) {
				if (dp(start + word.length())) {
					return true;
				}
			}
		}
		return false;
	}

}
