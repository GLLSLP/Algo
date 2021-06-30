import java.io.*;
import java.util.*;

public class 백준_1021_회전하는큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Integer> list = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 큐의 크기
		int M = Integer.parseInt(st.nextToken());// 뽑을수 개수
		for (int n = 1; n <= N; n++) {// 1-N까지 넣기
			list.add(n);
		}
		st = new StringTokenizer(br.readLine());
		int answer = 0;
		for (int m = 0; m < M; m++) {// 정답 구하기
			int num = Integer.parseInt(st.nextToken());
			int find = list.indexOf(num); // 찾을 수의 인덱스
			int half = list.size() / 2;

			if (half >= find) {// 왼쪽에 더 가까울때
				while (num != list.getFirst()) {
					list.offer(list.removeFirst());
					answer++;
				}
			} else { // 오른쪽에 더 가까울때
				while (num != list.getFirst()) {
					list.offerFirst(list.removeLast());
					answer++;
				}
			}
			list.remove();
		}
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
