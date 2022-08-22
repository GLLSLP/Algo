import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int [][][] arr = new int[21][21][21];
		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j <= 20; j++) {
				for (int k = 0; k <= 20; k++) {
					if (i == 0 || j == 0 || k == 0) {
						arr[i][j][k] = 1;
						continue;
					}

					if (i < j && j < k) {
						arr[i][j][k] = arr[i][j][k - 1] + arr[i][j - 1][k - 1] - arr[i][j - 1][k];
						continue;
					}

					arr[i][j][k] = arr[i - 1][j][k] + arr[i - 1][j - 1][k] + arr[i - 1][j][k - 1]
							- arr[i - 1][j - 1][k - 1];
				}
			}
		}

		StringBuilder sb =new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1) {
				break;
			}
			sb.append("w(" + a + ", " + b + ", " + c + ") = ");
			if (a <= 0 || b <= 0 || c <= 0) { //여기랑
				sb.append("1\n");
			} else if (a > 20 || b > 20 || c > 20) { //여기 순서 바뀌면 틀림..
				sb.append(arr[20][20][20]+"\n");
			} else {
				sb.append(arr[a][b][c]+"\n");
			}

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
