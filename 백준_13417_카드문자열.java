import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_13417_카드문자열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();

			for (int n = 0; n < N; n++) {
				char now = st.nextToken().charAt(0);
				if (n == 0) {
					sb.append(now);
				} else {
					char left = sb.charAt(0);
					if (left - '0' < now - '0') {
						sb.append(now);
					} else {
						sb.insert(0, now);
					}
				}

			}
			System.out.println(sb);
		}
	}

}
