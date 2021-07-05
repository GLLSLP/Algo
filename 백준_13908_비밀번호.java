import java.io.*;
import java.util.*;

public class 백준_13908_비밀번호 {
	static boolean[] check;
	static int N, M, answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 비밀번호길이
		M = Integer.parseInt(st.nextToken()); // 비밀번호에 들어가는 수
		check = new boolean[10];
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			int num = Integer.parseInt(st.nextToken());
			check[num] = true;
		}
		find(0, 0);
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

	private static void find(int index, int count) {
		// TODO Auto-generated method stub
		if (index == N) {
			if (count == M) {
				answer++;
			}
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (check[i]) {
				check[i] = false; // 꼭 써야 하는숫자를 중복 사용하는건 정답에 카운트하면 안되니까 잠시 false로...
				find(index + 1, count + 1); // 무조건 사용해야 하는 숫자 사용시 count+1
				check[i] = true;
			} else {
				find(index + 1, count);
			}
		}
	}

}
