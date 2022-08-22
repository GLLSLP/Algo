import java.io.*;
import java.util.*;

public class 백준_17298_오큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}

		int[] answer = new int[N];
		Stack<Integer> st = new Stack<>();

		for (int i = N - 1; i >= 0; i--) {
			while (!st.isEmpty() && st.peek() <= arr[i]) {
				int out = st.pop();
//				System.out.println(out+"나감");
			}
			if (st.isEmpty()) {
				answer[i] = -1;
			} else {
				answer[i] = st.peek();
			}
//			System.out.println(arr[i]+"넣음");
			st.push(arr[i]);
		}
		for (int i = 0; i < N; i++) {
			bw.write(Integer.toString(answer[i]) + " ");
		}
		bw.flush();
		bw.close();
	}

}
