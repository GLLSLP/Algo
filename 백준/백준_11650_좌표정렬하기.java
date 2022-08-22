import java.io.*;
import java.util.*;

public class 백준_11650_좌표정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (e1, e2) -> {
			if (e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});

		for (int n = 0; n < N; n++) {
			bw.write(Integer.toString(arr[n][0]) + " " + Integer.toString(arr[n][1]) + "\n");
		}
		bw.flush();
		bw.close();
	}

}