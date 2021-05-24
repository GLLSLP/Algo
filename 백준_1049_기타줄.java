import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1049_기타줄 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] one = new int[M];
		int[] six = new int[M];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			six[m] = Integer.parseInt(st.nextToken());
			one[m] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(one);
		Arrays.sort(six);
		int answer = 0;
		if (N < 6) {
			answer = Math.min(one[0]*N, six[0]); //***예외 : 6개짜리 팩 살때가 더 쌀때
		} else {
			int divide = N / 6;
			int packsPrice = divide * six[0];
			int remain = N % 6;
			int onePrice = remain * one[0];
			answer = Math.min(packsPrice + onePrice, packsPrice + six[0]);
			answer = Math.min(answer, N * one[0]);
		}
		System.out.println(answer);
	}

}
