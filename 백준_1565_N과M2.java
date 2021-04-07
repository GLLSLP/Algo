import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1565_N과M2 {
	static int N, M;
	static int[] num;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[M];
		find(0, 1);

	}

	private static void find(int c, int now) {
		// TODO Auto-generated method stub
		if (c == M) {
			Arrays.sort(num);
			for (int i = 0; i < M; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = now; i <= N; i++) {
			num[c] = i;
			find(c + 1, i + 1);// ***++가 아니라 +1***
		}
	}

}
