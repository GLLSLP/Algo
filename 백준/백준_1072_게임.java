import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1072_게임 {
	static long X, Y, first, answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
//		first = (Y/X)*100; *****이렇게 쓰면 틀림 ㄱ-*****
		first = 100 * Y / X;
		if (first >= 99) { // *****승률 99%랑 100%는 바꿀수 없으므로 -1*****
			System.out.println(-1);
		} else {
			find();
		}

	}

	private static void find() {
		// TODO Auto-generated method stub
		long start = 0;
		long end = 1000000000;
		long middle = 0;
		while (start <= end) {
			middle = (start + end) / 2;
//			long Z = (Y+middle)/(X+middle)*100;	*****이렇게 쓰면 틀림 ㄱ-*****
			long Z = 100 * (Y + middle) / (X + middle);
			if (first < Z) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		System.out.println(start);
	}

}
