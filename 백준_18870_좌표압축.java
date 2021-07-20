import java.io.*;
import java.util.*;

public class 백준_18870_좌표압축 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>(); // 값, 인덱스
		int[] arr = new int[N];
		int[] sor = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			arr[n] = num;
			sor[n] = num;
		}
		Arrays.sort(sor);
		int index = 0;
		for (int n = 0; n < N; n++) {
			if (!map.containsKey(sor[n])) { // 처음나오는 값이면
				map.put(sor[n], index++); // 인덱스 저장
			}
		}
		for (int n = 0; n < N; n++) {
			int find = arr[n];
			bw.write(Integer.toString(map.get(find)) + " ");
		}
		bw.flush();
		bw.close();
	}

}
