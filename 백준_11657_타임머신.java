import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static long maxValue = Long.MAX_VALUE;
	static ArrayList<Dot>[] list;
	static long[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시개수
		M = Integer.parseInt(st.nextToken()); // 버스개수
		distance = new long[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			distance[i] = maxValue;
			list[i] = new ArrayList<>();
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 시작
			int B = Integer.parseInt(st.nextToken()); // 도착
			int C = Integer.parseInt(st.nextToken()); // 시간
			list[A].add(new Dot(B, C));
		}

		if (Bell()) {
			for (int i = 2; i <= N; i++) {
				if (distance[i] == maxValue) {
					bw.write("-1\n");
				} else {
					bw.write(Long.toString(distance[i]) + "\n");
				}
			}
		} else {
			bw.write("-1");
		}

		bw.flush();
		bw.close();
	}

	private static boolean Bell() {
		distance[1] = 0;
		boolean check = false; // 값 변화 있었는지
		for (int n = 1; n <= N; n++) {
			check = false;
			for (int m = 1; m <= N; m++) {
				for (Dot temp : list[m]) {
					if (distance[m] != maxValue && distance[m] + temp.time < distance[temp.node]) {
						distance[temp.node] = distance[m] + temp.time;
						check = true;
					}
				}
			}
			//
			if(!check) {
				break;
			}
		}
		if (check) {
			return false;
		} else {
			return true;
		}
	}
}

class Dot {
	int node;
	int time;

	public Dot(int node, int time) {
		this.node = node;
		this.time = time;
	}
}