import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class 백준_1181_단어정렬 {
	static ArrayList<String> words = new ArrayList<String>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			String word = br.readLine();
			if (words.contains(word)) {
				continue;
			}
			words.add(word);
		}
		// 정렬
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				// 단어 길이가 같을 경우
				if (o1.length() > o2.length()) {
					return 1;
				} else if (o1.length() < o2.length()) {
					return -1;
				} else {
					return o1.compareTo(o2);
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < words.size(); m++) {
			sb.append(words.get(m) + "\n");
		}
		System.out.println(sb);
	}

}
