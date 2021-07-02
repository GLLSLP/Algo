import java.io.*;
import java.util.*;

public class 백준_15903_카드합체놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int n = 0; n < N; n++) {
			long num = Long.parseLong(st.nextToken());
			pq.offer(num);
		}
		for (int m = 0; m < M; m++) {
			long a = pq.poll();
			long b = pq.poll();
			pq.offer(a + b);
			pq.offer(a + b);
		}
		long answer = 0;
		while (!pq.isEmpty()) {
			answer += pq.poll();
		}
		bw.write(Long.toString(answer));
		bw.flush();
		bw.close();
	}

}
