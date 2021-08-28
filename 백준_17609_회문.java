import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String line = br.readLine();
			int ans = find(line, 0);
			System.out.println(ans);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int find(String line, int count) {
		int start = 0;
		int end = line.length() - 1;
		while (start < end) {
			if (line.charAt(start) == line.charAt(end)) {
				start++;
				end--;
			} else {
				if (count == 1) {
					count++;
					break;
				}

				if (start + 1 <= end && line.charAt(start + 1) == line.charAt(end)) {
					int temp = find(line.substring(start + 1, end + 1), 1);
					if (temp == 1) {
						count = 1;
						break;
					}

				}
				if (start <= end - 1 && line.charAt(start) == line.charAt(end - 1)) {
					int temp = find(line.substring(start, end), 1);
					if (temp == 1) {
						count = 1;
						break;
					}

				}
				count = 2;
				break;
			}

		}
		return count;
	}

}
