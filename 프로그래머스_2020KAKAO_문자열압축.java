import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String s = "abcabcabcabcdededededede";
		int answer = s.length();

		int len = 1;
		while (true) {
			if (len > s.length() / 2) {
				break;
			}
			answer = Math.min(answer, find(s, len));
			len++;
		}
		System.out.println(answer);
	}

	private static int find(String line, int len) {
		StringBuilder sb = new StringBuilder();
		String front = line.substring(0, len);
		int start = len;
		int count = 1;
		while (true) {
			if (start >= line.length()) {
				if (count == 1) {
					sb.append(front);
				} else {
					sb.append(count + front);
				}
				break;
			}
			int end = start + len;
			if (end > line.length()) {
				if (count == 1) {
					sb.append(front);
				} else {
					sb.append(count + front);
				}
				sb.append(line.substring(start, line.length()));
				break;
			}
			String word = line.substring(start, end);
			if (front.equals(word)) {
				count++;
				start = end;
			} else {
				if (count == 1) {
					sb.append(front);
				} else {
					sb.append(count + front);
				}
				front = word;
				start = end;
				count = 1;
			}

		}
		return sb.toString().length();
	}
}
