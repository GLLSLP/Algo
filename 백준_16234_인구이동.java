import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_16234_인구이동 {
	static int N, MIN, MAX, count, sum, countries = 1;
	static boolean flag;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static Queue<Node> queue = new LinkedList<Node>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//
		MIN = sc.nextInt();
		MAX = sc.nextInt();
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				map[n][m] = sc.nextInt();
			}
		}
		while (true) {
			visit = new boolean[N][N];
			flag = false;
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					if (!visit[n][m]) {
						sum = 0;
						countries = 0;
						bfs(n, m);
						while (!queue.isEmpty()) {
							Node temp = queue.poll();
							int avg = sum / countries;
							map[temp.x][temp.y] = avg;
						}
					}
				}
			}
			if (!flag) {
				break;
			}
			count++;
		}
		System.out.println(count);
	}

	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true;
		sum += map[x][y];
		countries++;
		queue.add(new Node(x, y));
		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];
			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
				int gap = Math.abs(map[nextX][nextY] - map[x][y]);
				if (!visit[nextX][nextY] && gap >= MIN && gap <= MAX) {
					bfs(nextX, nextY);
					flag = true;
				}
			}
		}
	}

	private static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
