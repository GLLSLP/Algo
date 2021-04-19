import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1431_시리얼번호 {
	static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			list.add(br.readLine());
		}
		list.sort(new Comparator<String>() {
			// -1이 앞에오는거..
			@Override
			public int compare(String one, String two) {
				if (one.length() < two.length()) {
					return -1;
				} else if (one.length() > two.length()) {
					return 1;
				} else {// 1번으로 비교할 수 없을때
					int n = sum(one);
					int m = sum(two);
					if (n < m) {
						return -1;
					} else if (n > m) {
						return 1;
					} else {// 2번으로 비교할 수 없을때
						if (one.compareTo(two) < 0) {// 아스키코드 one-two값...즉 0보다 작을때 = one이 더 앞에올때
							return -1;
						} else {
							return 1;
						}
					}
				}
			}
		});

		// 결과출력
		for (String line : list) {
			System.out.println(line);
		}
	}

	private static int sum(String num) {
		// TODO Auto-generated method stub
		int result = 0;
		for (int n = 0; n < num.length(); n++) {
			if (num.charAt(n) >= '0' && num.charAt(n) <= '9') {// ****
				result += num.charAt(n) - '0';
			}
		}
		return result;
	}

}
