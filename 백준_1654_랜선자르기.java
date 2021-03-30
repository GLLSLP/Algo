import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1654_랜선자르기 {
	static long K, N, answer;
	static long[] num;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		num = new long[(int) K];
		for (int k = 0; k < K; k++) {
			num[k] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		find();
		System.out.println(answer);
	}

	private static void find() {
		// TODO Auto-generated method stub
		long start = 1;
		long end = Integer.MAX_VALUE;// *****end를 Integer.MAX_VALUE로 하기..랜선 최대길이가 딱 여기까지임

		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for (int i = 0; i < K; i++) {
				sum += num[i] / mid;
			}
			if (sum < N) {// 부족하면
				end = mid - 1;
			} else {// 충분하면
				answer = Math.max(answer, mid);
				start = mid + 1;
			}
		}
	}

}
