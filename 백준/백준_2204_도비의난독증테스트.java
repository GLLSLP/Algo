import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 백준_2204_도비의난독증테스트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while (N != 0) {
			String[] list = new String[N];
			for (int i = 0; i < N; i++) {
				list[i] = br.readLine();
			}
			Arrays.sort(list, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.toLowerCase().compareTo(o2.toLowerCase());
				}
			});
			System.out.println(list[0]);
			N = Integer.parseInt(br.readLine());
		}

	}
}
