import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2166_다각형의면적 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double answer = 0;
		// 신발끈 공식으로 푸는 문제
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nowX = Integer.parseInt(st.nextToken());
		int nowY = Integer.parseInt(st.nextToken());
		int oneX = nowX;
		int oneY = nowY;
		for (int n = 1; n <= N - 1; n++) {
			st = new StringTokenizer(br.readLine());
			int nextX = Integer.parseInt(st.nextToken());
			int nextY = Integer.parseInt(st.nextToken());
			answer += (double) nowX * nextY; // 틀린이유1. double뺌
			answer -= (double) nextX * nowY;
			nowX = nextX;
			nowY = nextY;
		}
		answer += (double) nowX * oneY;
		answer -= (double) oneX * nowY;
		System.out.printf("%.1f", Math.abs(answer) / 2); // 틀린이유2. "%.1f"안함
	}

}
