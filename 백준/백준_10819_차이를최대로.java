import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10819_차이를최대로 {
	static int N, answer;
	static int[] input;
	static int[] nums;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[N];
		nums = new int[N];
		isSelected = new boolean[N];
		for (int n = 0; n < N; n++) {
			input[n] = Integer.parseInt(st.nextToken());
		}
		perm(0);

		System.out.println(answer);
	}

	private static void perm(int c) {
		// TODO Auto-generated method stub
		if (c == N) {
			int temp = 0;
			for (int i = 0; i <= N - 2; i++) {
				temp += Math.abs(nums[i] - nums[i + 1]);
			}
			answer = Math.max(answer, temp);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				continue;
			}

			isSelected[i] = true;
			nums[c] = input[i];
			perm(c + 1);
			isSelected[i] = false;
		}

	}

}
