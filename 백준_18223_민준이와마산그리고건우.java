import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] dis;
	static int max = 100001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 도시개수
		M = Integer.parseInt(br.readLine()); // 버스개수
		dis = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j)
					dis[i][j] = max;
			}
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dis[a][b] = Math.min(dis[a][b], c);
		}

		floyd();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dis[i][j] == 100001)
					bw.write("0 ");
				else
					bw.write(Integer.toString(dis[i][j]) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	private static void floyd() {
		for (int mid = 1; mid <= N; mid++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dis[i][j] = Math.min(dis[i][j], dis[i][mid] + dis[mid][j]);
				}
			}
		}
	}

}
