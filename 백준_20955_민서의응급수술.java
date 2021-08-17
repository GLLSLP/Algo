import java.io.*;
import java.util.*;

public class Main {
	static int N, M, answer;
	static int[] union;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		union = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			union[i] = i;
		}

		// 사이클이 아니면 그냥 평범하게 이어지고 사이클이면 끊어야 하므로 연산횟수+1
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if (!union(u, v)) { // 사이클이라 연결끊음
				answer++;
			}
		}

		HashSet<Integer> hs = new HashSet<>(); // 중복이 안들어가서
		for (int i = 1; i <= N; i++) {
			int root = root(i);
			hs.add(root);
		}
		answer += hs.size() - 1;

		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}

	private static boolean union(int u, int v) {
		int rU = root(u);
		int rV = root(v);
		if (rU != rV) {
			union[rV] = rU;
			return true;
		}
		return false;
	}

	private static int root(int num) {
		if (num == union[num]) {
			return num;
		} else {
			return union[num] = root(union[num]);
		}
	}

}