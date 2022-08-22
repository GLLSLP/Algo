import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N - 1][2];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N - 1; n++) {
			arr[n][0] = Integer.parseInt(st.nextToken()); // 거리
		}
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N - 1; n++) {
			arr[n][1] = Integer.parseInt(st.nextToken()); // 가격
		}

		long answer = 0;
		long min = Integer.MAX_VALUE;
		for (int n = 0; n < N - 1; n++) {
			min = Math.min(min, arr[n][1]);
			answer += min * arr[n][0];
		}
		bw.write(Long.toString(answer));
		bw.flush();
		bw.close();
	}

}
