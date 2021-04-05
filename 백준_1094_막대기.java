import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1094_막대기 {
	static int X;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		System.out.println(find(X));
	}

	private static int find(int n) {
		// TODO Auto-generated method stub
		int answer = 0;
		while (n > 0) {
			answer += n & 1;
			n >>= 1;
		}
		return answer;
	}

}
