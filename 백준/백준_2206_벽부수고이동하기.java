import java.io.*;
import java.util.*;

public class 백준_2206_벽부수고이동하기 {
	static int N, M;
	static int[][] map;
	static BufferedWriter bw;
	static boolean[][][] check;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		check = new boolean[N][M][2];
		for (int n = 0; n < N; n++) {
			String line = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = line.charAt(m) - '0';
			}
		}

		bfs();

		bw.flush();
		bw.close();
	}


	private static void bfs() throws IOException {
		// TODO Auto-generated method stub
		check[0][0][0] = true;
		check[0][0][1] = true;
		Queue<Dot> queue = new LinkedList<>();
		queue.offer(new Dot(0, 0, 1, 0));
		while (!queue.isEmpty()) {
			Dot temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			int move = temp.move;
			int brick = temp.brick;
			if (x == N - 1 && y == M - 1) {
				bw.write(Integer.toString(move));
				return;
			}
			for (int d = 0; d < 4; d++) {
				int dx = dir[d][0] + x;
				int dy = dir[d][1] + y;
				if (dx < 0 || dx >= N || dy < 0 || dy >= M) {
					continue;
				}

				if (map[dx][dy] == 1) {// 벽o
					if (brick == 0 && !check[dx][dy][1]) {
						check[dx][dy][1] = true;
						queue.offer(new Dot(dx, dy, move + 1, 1));
					}
				} else {// 벽x
					if (!check[dx][dy][brick]) {
						check[dx][dy][brick] = true;
						queue.offer(new Dot(dx, dy, move + 1, brick));
					}
				}
			}
		}
		bw.write("-1");
	}

}

class Dot {
	int x;
	int y;
	int move;
	int brick;

	public Dot(int X, int Y, int Move, int Brick) {
		x = X;
		y = Y;
		move = Move;
		brick = Brick;
	}
}
