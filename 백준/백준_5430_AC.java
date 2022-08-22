import java.io.*;
import java.util.*;

public class 백준_5430_AC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String func = br.readLine();
			int N = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();

			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

			for (int i = 0; i < N; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			StringBuilder sb = new StringBuilder();
			boolean flag = false; // false일때 정방향, true일때 역방향
			boolean error = false;// 에러인지 아닌지

			for (int i = 0; i < func.length(); i++) {
				char f = func.charAt(i);
				if (f == 'R') {
					flag = !flag;
				} else if (f == 'D') {
					if (dq.size() == 0) {
						sb.append("error");
						error = true;
						break;
					}
					if (flag) { // 역방향일땐 오른쪽 삭제
						dq.pollLast();
					} else { // 정방향일땐 왼쪽 삭제
						dq.pollFirst();
					}
				}
			}

			// 출력
			if (error == false) {
				sb.append('[');
				if (dq.size() > 0) {
					if (flag) { // 뒤집어서 출력
						while (!dq.isEmpty()) {
							sb.append(dq.pollLast()).append(",");
						}
					} else { // 정방향으로 출력
						while (!dq.isEmpty()) {
							sb.append(dq.pollFirst()).append(",");
						}
					}
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append("]");
			}
			sb.append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}

}
