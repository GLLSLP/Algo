import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		boolean minus = false;// 숫자만들기
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) >= '0' && line.charAt(i) <= '9') { // 숫자일때
				sb.append(line.charAt(i));
				// 마지막이면
				if (i == line.length() - 1) {
					if (minus == false) {
						answer += Integer.parseInt(sb.toString());
					} else {
						answer -= Integer.parseInt(sb.toString());
					}
				}
			} else { // 연산자일때
				if (line.charAt(i) == '-') {// -한번이라도 마이너스 나오면 그 뒤에 + 다 -화 가능
					if (minus == false) {// 처음 -나온거면 지금 숫자까진 더할수 있는거..
						answer += Integer.parseInt(sb.toString());
					} else {
						answer -= Integer.parseInt(sb.toString());
					}
					minus = true;
				} else {
					if (minus == false) {
						answer += Integer.parseInt(sb.toString());
					} else {
						answer -= Integer.parseInt(sb.toString());
					}
				}
				sb.setLength(0);// sb초기화
			}
		}
		System.out.println(answer);
	}

}
