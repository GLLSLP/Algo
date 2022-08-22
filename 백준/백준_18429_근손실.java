import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_18429_근손실 {
	static int N, K, answer;
	static int[] weight;
	static int[] set;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		weight = new int[N];
		set = new int[N];
		isSelected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			weight[n] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		System.out.println(answer);
	}

	private static void perm(int cnt) {
		// TODO Auto-generated method stub
		if (cnt == N) {
			// 조건에 맞는지
//			System.out.println(Arrays.toString(set));
			int w = 500;
			for (int i = 0; i < N; i++) {
				w = w + set[i] - K;
				if (w < 500) {
					return;
				}
			}
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])// 이미뽑힘
				continue;
			isSelected[i] = true;
			set[cnt] = weight[i];
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}

}
