import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_4889_안정적인문자열 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (true) {
			int count = 0;
			String line = br.readLine();
			if (line.charAt(0) == '-') {
				break;
			}
			Stack<Character> st = new Stack<>();
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '{') {
					st.add(line.charAt(i));
				} else {
					if (st.isEmpty()) { // 열린괄호 없는데 닫힌괄호나옴
						st.add('{');// ***여기
						count++;
					} else {
						st.pop();
					}
				}
			}
			if (!st.isEmpty()) {
				count += st.size() / 2;
			}
			System.out.println(t + ". " + count);
			t++;
		}
	}

}
