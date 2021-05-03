import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_17609_회문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String line = br.readLine();
			System.out.println(find(line));
		}
	}

	private static int find(String line) {
		// TODO Auto-generated method stub
		int start = 0;
		int end = line.length() - 1;
		int count = 0;// 다른 횟수
		while (start <= end) {
			if (line.charAt(start) == line.charAt(end)) {
				start++;
				end--;
			} else {
				int s = start;
				int e = end;
				s++;
				while (s <= e) {
					if (line.charAt(s) == line.charAt(e)) {
						s++;
						e--;
					} else {
						count++;
						break;
					}
				}

				s = start;
				e = end;
				e--;
				while (s <= e) {
					if (line.charAt(s) == line.charAt(e)) {
						s++;
						e--;
					} else {
						count++;
						break;
					}
				}
				return count;
			}
		}
		return 0;

	}

}
