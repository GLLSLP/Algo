import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준_20920_영단어암기는괴로워 {
	static int N, M;
	static ArrayList<String> words = new ArrayList<String>();
	static HashMap<String, Integer> map = new HashMap<String, Integer>(M);

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int n = 0; n < N; n++) {
			String w = br.readLine();
			if (w.length() < M) { // M보다 짧은 단어 안외움
				continue;
			}
			if (map.get(w) == null) {// 처음보는단어
				words.add(w);
				map.put(w, 1);
			} else { // 이미 등록된 단어
				map.replace(w, map.get(w) + 1);
			}
		}

		// 정렬
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int c1 = map.get(o1);
				int c2 = map.get(o2);
				// 단어 빈도가 같을 경우
				if (c1 == c2) {
					// 단어 길이가 같을 경우
					if (o1.length() == o2.length()) {
						// 사전 순 정렬*****
						return o1.compareTo(o2);
					}
					// 그 외
					if (o1.length() > o2.length()) {
						return -1; // 내림차순
					} else {
						return 1;
					}
				}
				// 그 외
				if (c1 > c2) {
					return -1;
				} else {
					return 1;
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
