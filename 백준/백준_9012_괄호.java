import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_9012_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			int N = sb.length();
			if (N % 2 == 1) {
				System.out.println("NO");
			} else {
				System.out.println(find(sb, N / 2));
			}

		}
	}

	private static String find(StringBuilder sb, int limit) {
		// TODO Auto-generated method stub
		int cnt = 0;
		while (cnt < limit) {
			for (int i = 0; i < sb.length() - 1; i++) {
				if (sb.charAt(i) == '(' && sb.charAt(i + 1) == ')') {
					sb.delete(i, i + 2);
					break;
				}
			}
			cnt++;
		}
		if (sb.length() == 0) {
			return "YES";
		} else {
			return "NO";
		}

	}

}
