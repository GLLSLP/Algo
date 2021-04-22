import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_17413_단어뒤집기2 {
	static String line;
	static boolean reverse = false;
	static Stack<Character> st = new Stack<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		line = br.readLine();
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != ' ' && line.charAt(i) != '<' && line.charAt(i) != '>') { // 숫자or문자 일때
				// 태그안에 있을때 그대로
				if (reverse == true) {
					sb.append(line.charAt(i));
				} else {// 태그밖에 있을때 = 뒤집
					st.add(line.charAt(i));
				}
				if (i == line.length() - 1) {// 마지막
					while (!st.isEmpty()) {
						sb.append(st.pop());
					}
				}

			} else {// 특수문자는 그대로

				if (line.charAt(i) == '<') {
					while (!st.isEmpty()) {
						sb.append(st.pop());
					}

					reverse = true;
				} else if (line.charAt(i) == '>') {

					reverse = false;
				} else {// 공백
					while (!st.isEmpty()) {
						sb.append(st.pop());
					}

				}
				sb.append(line.charAt(i));
			}
		}
		System.out.println(sb);
	}

}
