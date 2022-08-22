import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_3273_두수의합 {
	static int N, X, answer;
	static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[N];
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		X = Integer.parseInt(br.readLine());
		Arrays.sort(num);
		find();
		System.out.println(answer);
	}

	private static void find() {
		// TODO Auto-generated method stub
		int index = 0;

		while (index < N - 1) {
			for (int e = N - 1; e > index; e--) {
				if (num[index] + num[e] == X) {
					answer++;
					break;
				}
			}
			index++;
		}
	}

}
