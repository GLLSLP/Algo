import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1316_그룹단어체커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int n = 0; n < N; n++) {
			StringBuffer word = new StringBuffer(br.readLine());

			boolean[] check = new boolean[26];
			char be = ' ';
			for (int w = 0; w < word.length(); w++) {
				int i = word.charAt(w) - 'a';
				if (check[i]) {
					if (be != ' ' && be != word.charAt(w)) {
						break;
					} else {
						be = word.charAt(w);
					}
				} else {
					be = word.charAt(w);
					check[i] = true;
				}

				if (w == word.length() - 1) {
					answer++;
				}
			}

		}
		System.out.println(answer);
	}

}
