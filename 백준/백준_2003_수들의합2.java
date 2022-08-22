import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2003_수들의합2 {
	static long N, M, answer;
	static long[] num;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new long[(int) N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
//		Arrays.sort(num);//넣지말라..
		find();
		System.out.println(answer);

	}

	private static void find() {
		// TODO Auto-generated method stub
		int start = 0;
		int end = 0;
		long sum = 0;
		while (true) {
			if (sum >= M) {// 줄여야함
				// 이렇게 하면 안됨..index out of~나옴
//				start++;
//				sum -= num[start];
				sum = sum - num[start++];
			} else if (end >= N) { // 끝에 도달
				return;
//				break;
			} else {// 늘려야함
					// 이렇게 하면 안됨..index out of~나옴
//				end++;
//				sum += num[end];
				sum = sum + num[end++];
			}
			if (sum == M) {// 원하는것
				answer++;
			}
		}
	}

}
