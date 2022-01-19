import java.util.*;
import java.io.*;

public class Main {
	static int H, W, answer;
	static int[] map;
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		map = new int[W];
		visit = new boolean[H + 1][W];
		for (int w = 0; w < W; w++) {
			map[w] = Integer.parseInt(st.nextToken());
		}
		find();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

	private static void find() {
		for (int w = 0; w < W; w++) {
			int block = map[w];
			for (int h = 1; h <= H; h++) {
				if (h > block) {
					break;
				}
				int temp = 0;
				for (int nw = w + 1; nw < W; nw++) {
					if (map[nw] < h) {
						temp++;
					} else {
						answer += temp;
						break;
					}
				}
			}
		}
	}

}
