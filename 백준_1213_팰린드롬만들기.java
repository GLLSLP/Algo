import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1213_팰린드롬만들기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		char[] alpha = new char[26];
		for (int l = 0; l < line.length(); l++) {
			char c = line.charAt(l);
			alpha[c - 'A']++;
		}
		// 홀수개인 알파벳이 2개이상이면 실패
		int count = 0;
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] % 2 == 1) {
				count++;
			}
		}
		String answer = "";
		if (count >= 2) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			// 잘 붙이기
			int remain = 0;
			for (int i = 0; i < alpha.length; i++) {
				if (alpha[i] == 0) {
					continue;
				}
				for (int j = alpha[i]; j > 1; j = j - 2) {// 개수만큼 붙이기
					answer = answer.substring(0, answer.length() / 2) + (char) (i + 'A') + (char) (i + 'A')
							+ answer.substring(answer.length() / 2);
					alpha[i] -= 2;
				}
				if (alpha[i] == 1) {
					remain = i;// 남은 알파벳 인덱스 저장
				}
			}
			if (count == 1) {
				answer = answer.substring(0, answer.length() / 2) + (char) (remain + 'A')
						+ answer.substring(answer.length() / 2);
			}
		}
		System.out.println(answer);

	}

}
