import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 백준_7785_회사에있는사람 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>(); //시간초과 방지.. 가장 빠른 임의접근 속도, 순서x
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			if (st.nextToken().equals("enter")) {
				set.add(name);
			} else {
				set.remove(name);
			}
		}
		String []arr = set.toArray(new String[set.size()]); //HashSet 정렬 없으니까 배열로 변환
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length-1; i >= 0; i--) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}

}
