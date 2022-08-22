import java.io.*;
import java.util.*;

public class 백준_2146_다리만들기 {
	static int N;
	static int[][] map;
	static boolean[][] check;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		for (int x = 0; x < N; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int y = 0; y < N; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		// DFS : 각 섬에 번호 붙이기
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !check[i][j]) {
					dfs(i, j, num);
					num++;
				}
			}
		}
		
		// BFS : 다리놓기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					bfs(i, j);
				}
			}
		}
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
	}

	private static void bfs(int x, int y) {
		int now = map[x][y];
		check = new boolean[N][N];
		check[x][y]=true;
		Queue<Dot> queue = new LinkedList<>();
		queue.offer(new Dot(x,y,0));
		while(!queue.isEmpty()) {
			Dot temp = queue.poll();
			for (int d = 0; d < 4; d++) {
				int dx = dir[d][0]+temp.x;
				int dy = dir[d][1]+temp.y;
				if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
					continue;
				}
				if(check[dx][dy]) {
					continue;
				}
				if(map[dx][dy]!=0 && map[dx][dy]!=now) {
					min = Math.min(min, temp.c);
					continue;
				}
				queue.offer(new Dot(dx,dy,temp.c+1));
				check[dx][dy]=true;
			}
		}
	}

	private static void dfs(int x, int y, int num) {
		// TODO Auto-generated method stub
		check[x][y] = true;
		map[x][y] = num;
		for (int d = 0; d < 4; d++) {
			int dx = x + dir[d][0];
			int dy = y + dir[d][1];
			if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
				continue;
			}
			if (check[dx][dy] || map[dx][dy] == 0) {
				continue;
			}
			dfs(dx, dy, num);
		}
	}

}

class Dot {
	int x;
	int y;
	int c;
	public Dot(int X, int Y, int C) {
		x = X;
		y = Y;
		c = C;
	}
}