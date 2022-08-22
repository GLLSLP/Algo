import java.io.*;
import java.util.*;

public class 백준_1966_프린터큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>(); // 문서들의 우선순위
			Queue<Boolean> mFlag = new LinkedList<>(); // 정답 문서를 true로 표시
			ArrayList<Integer> arr = new ArrayList<>(); // 문서들의 우선순위를 정렬해놓을거
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				arr.add(num);
				if (i == M) {
					mFlag.add(true);
				} else {
					mFlag.add(false);
				}
			}
			Collections.sort(arr);
			int index = arr.size() - 1;
			int count = 0;
			while (true) {
				int num = queue.poll();
				boolean flag = mFlag.poll();
				if (arr.get(index) > num) {// 나보다 높은 우선순위 문서가 있을때
					queue.add(num);
					mFlag.add(flag);
				} else {// 출력해야할때
					if (flag) {// 차례
						count++;
						bw.write(Integer.toString(count) + "\n");
						break;
					} else {
						count++;
					}
					index--;
				}
			}
		}
		bw.flush();
		bw.close();
	}

}
