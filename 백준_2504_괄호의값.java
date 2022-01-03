import java.util.*;
import java.io.*;

public class Main {
	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		int answer = find(line);
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

	private static int find(String line) {
		int result = 0;
		int temp = 1;

		for (int i = 0; i < line.length(); i++) {
			char now = line.charAt(i);

			if (now == '(') {
				temp *= 2;
				stack.add(now);
			} else if (now == '[') {
				temp *= 3;
				stack.add(now);
			} else {
				if (stack.isEmpty()) { // 올바르지 않은 문자열(왼쪽괄호가 더 많음)
					result = 0;
					break;
				}
				if (now == ']') {
					if (stack.peek() != '[') { // 올바르지 않은 문자열(짝 안맞음)
						result = 0;
						break;
					}
					// 직전과 짝이 맞을때
					if (line.charAt(i - 1) == '[') {
						result += temp;
					}
					// 직전에 )or] 일때
					temp /= 3;
					stack.pop();

				} else if (now == ')') {
					if (stack.peek() != '(') { // 올바르지 않은 문자열(짝 안맞음)
						result = 0;
						break;
					}
					// 직전과 짝이 맞을때
					if (line.charAt(i - 1) == '(') {
						result += temp;
					}
					// 직전에 )or] 일때
					temp /= 2;
					stack.pop();
				}
			}
		}
		if (!stack.isEmpty()) {
			result = 0;
		}
		return result;
	}

}
