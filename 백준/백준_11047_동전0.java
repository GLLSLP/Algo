import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		for (int n = 0; n < N; n++) {
			coin[n] = Integer.parseInt(br.readLine());
		}
		int count = 0;
		for (int n = N - 1; n >= 0; n--) {
			int num = coin[n];
			if (num > K) {
				continue;
			}
			count += K / num;
			K %= num;
		}
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
	}
}
