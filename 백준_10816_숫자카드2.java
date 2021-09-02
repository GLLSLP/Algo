import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[20000001];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			arr[num + 10000000]++;
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			int num = Integer.parseInt(st.nextToken());
			bw.write(arr[num + 10000000] + " ");
		}

		bw.flush();
		bw.close();
	}

}
