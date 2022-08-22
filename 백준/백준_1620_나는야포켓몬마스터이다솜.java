import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준_1620_나는야포켓몬마스터이다솜 {
	static int N, M;
	static HashMap<String, Integer> map = new HashMap<String, Integer>(N);
	static HashMap<Integer, String> map2 = new HashMap<Integer, String>(N);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int n = 0; n < N; n++) {
			String line = br.readLine();
			map2.put(n + 1, line);
			map.put(line, n + 1);
		}
		for (int m = 0; m < M; m++) {
			String line = br.readLine();
			if (isStringInteger(line)) {
				System.out.println(map2.get(Integer.parseInt(line)));
			} else {
				System.out.println(map.get(line));
			}
		}
	}

	static boolean isStringInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
