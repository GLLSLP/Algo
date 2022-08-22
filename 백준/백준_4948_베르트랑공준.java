import java.io.*;

public class 백준_4948_베르트랑공준 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//미리 소수인지 아닌지 저장해두고
		boolean[] arr = new boolean[123456 * 2 + 1];
		for (int i = 1; i < arr.length; i++) {
			int root = (int) Math.sqrt(i);
			for (int j = 1; j <= root; j++) {
				if (j != 1 && i % j == 0) {
					break;
				} else if (i != 1 && j == root) {
					arr[i] = true;
				}
			}
		}
		//꺼내다쓰는게 빠름
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			int count = 0;
			for (int i = N + 1; i <= 2 * N; i++) {
				if (arr[i]) {
					count++;
				}
			}
			bw.write(Integer.toString(count) + "\n");
		}
		bw.flush();
		bw.close();
	}

}
