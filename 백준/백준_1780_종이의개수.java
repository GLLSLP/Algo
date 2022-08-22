import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int minus, zero, plus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cut(0, 0, N);

		bw.write(Integer.toString(minus) + "\n" + Integer.toString(zero) + "\n" + Integer.toString(plus));
		bw.flush();
		bw.close();
	}

	private static void cut(int x, int y, int size) {
		int flag = map[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (flag != map[i][j]) {
					flag = -2;
				}
			}
		}

		if (flag == -2) {
			int small = size / 3;
			if (small > 0) {
				for (int p = 0; p < 3; p++) {
					for (int q = 0; q < 3; q++) {
						cut(x + p * small, y + q * small, small);
					}
				}
			}
		} else {
			if (flag == -1) {
				minus++;
			} else if (flag == 1) {
				plus++;
			} else if (flag == 0) {
				zero++;
			}
		}
	}

}
