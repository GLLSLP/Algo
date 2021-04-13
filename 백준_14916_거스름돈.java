import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_14916_거스름돈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if ((N % 5) % 2 == 0) {// 5원 사용 후 잔돈을 2원짜리로 줄 수 있을 때
			System.out.println(N / 5 + N % 5 / 2);
		} else if (N / 5 == 0) {// 5원 아예 안씀
			System.out.println(-1);
		} else {// 5원 사용 후 잔돈을 2원짜리로 줄 수 없을 때
			System.out.println(N / 5 - 1 + (N % 5 + 5) / 2);
		}
	}

}
