import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2512_예산 {
	static long N, M, answer;
	static int[] money;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		money = new int[(int) N];
		for (int n = 0; n < N; n++) {
			money[n] = (int) Long.parseLong(st.nextToken());
		}
		M = Long.parseLong(br.readLine());
		Arrays.sort(money);

		System.out.println(find());
	}

	private static long find() {
		// TODO Auto-generated method stub
		long start = 1;
		long end = money[(int) (N - 1)];
		while (start <= end) {
			long middle = (start + end) / 2;
			long sum = 0;
			for (int n = 0; n < N; n++) {
				if (money[n] <= middle) {
					sum += money[n];
				} else {
					sum += middle;
				}
			}
			if (sum <= M) {// *** <가 아니라 <=이다. ㄱ-..
				answer = Math.max(answer, middle);
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}
		return (int) answer;
	}

}
