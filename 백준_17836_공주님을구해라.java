import java.io.*;
import java.util.*;

public class 백준_17836_공주님을구해라 {
	static int N, M, T;
	static int[][] map;
	static boolean[][][] check;
	static int minTime = Integer.MAX_VALUE;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int[][] time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		time = new int[N][M];
		check = new boolean[2][N][M];
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < M; y++) {
				int n = Integer.parseInt(st.nextToken());
				map[x][y] = n;
			}
		}
		bfs();
		if (minTime == Integer.MAX_VALUE) {
			bw.write("Fail");
		} else {
			bw.write(Integer.toString(minTime));
		}
		bw.flush();
		bw.close();
	}

	private static void bfs() {
		Queue<Dot> queue = new LinkedList<>();
		queue.offer(new Dot(0, 0, 0));
		check[0][0][0] = true;
		check[1][0][0] = true;
		while (!queue.isEmpty()) {
			Dot temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			int brick = temp.brick;
			if (x == N - 1 && y == M - 1) { // 도착
				minTime = Math.min(minTime, time[x][y]);
				continue;
			}

			if (time[x][y] >= T) { // 시간내 도착 못함
				continue;
			}
			if (map[x][y] == 2) {// 그랑 잡음
				brick = 1;
			}
			for (int d = 0; d < 4; d++) {
				int dx = dir[d][0] + x;
				int dy = dir[d][1] + y;
				if (dx < 0 || dx >= N || dy < 0 || dy >= M) {
					continue;
				}
				if (check[brick][dx][dy]) {
					continue;
				}
				if (brick == 0 && map[dx][dy] == 1) {
					continue;
				}
				queue.offer(new Dot(dx, dy, brick));
				time[dx][dy] = time[x][y] + 1;
				check[brick][dx][dy] = true;
			}
		}
	}

}

class Dot {
	int x;
	int y;
	int brick;

	public Dot(int X, int Y, int Brick) {
		x = X;
		y = Y;
		brick = Brick;
	}
}