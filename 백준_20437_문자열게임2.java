import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int T, K, min, max;
	static String line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			arr = new int[26];
			line = br.readLine();
			K = Integer.parseInt(br.readLine());
			if (K == 1) {
				bw.write("1 1\n");
				continue;
			}
			for (int i = 0; i < line.length(); i++) {
				arr[line.charAt(i) - 'a']++;
			}
			min = Integer.MAX_VALUE;
			max = 0;
			for (int i = 0; i < 26; i++) {
				if (arr[i] < K) {
					continue;
				}
				shortnlong((char) (i + 'a'));
			}
			if (min == Integer.MAX_VALUE || max == 0) {
				bw.write("-1\n");
			} else {
				bw.write(Integer.toString(min) + " " + Integer.toString(max) + "\n");
			}
		}

		bw.flush();
		bw.close();
	}

	private static void shortnlong(char c) {
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int flag = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != c) {
				continue;
			}
			if (count < K) {
				list.add(i);
				count++;

				if (count == K) {
					max = Math.max(max, list.get(K - 1) - list.get(0) + 1);
					min = Math.min(min, list.get(K - 1) - list.get(0) + 1);
				}
				continue;
			}
			list.add(i);
			flag++;
			max = Math.max(max, list.get(K - 1 + flag) - list.get(flag) + 1);
			min = Math.min(min, list.get(K - 1 + flag) - list.get(flag) + 1);
		}

	}

}
