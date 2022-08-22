import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_2012_등수매기기 {
	static int N;
	static long answer; // int말고
	static int[] pred;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pred = new int[N];
		for (int n = 0; n < N; n++) {
			pred[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(pred);
		for (int n = 0; n < N; n++) {
			answer += Math.abs(pred[n] - (n + 1));
		}
		System.out.println(answer);

	}

}
