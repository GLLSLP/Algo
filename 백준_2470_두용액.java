import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0;
		int end = N - 1;
		int min = Integer.MAX_VALUE;
		int x = 0, y = 0;
		while (start < end) {
			int sum = arr[end] + arr[start];
			int gap = Math.abs(sum);
			if (gap == 0) {
				x = start;
				y = end;
				break;
			} else if (gap < min) {
				min = gap;
				x = start;
				y = end;
			}
			if (sum > 0) {
				end--;
			} else if (sum < 0) {
				start++;
			}
		}
		bw.write(Integer.toString(arr[x]) + " " + Integer.toString(arr[y]));
		bw.flush();
		bw.close();
	}

}
