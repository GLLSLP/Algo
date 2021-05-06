import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1769_3의배수 {
	static String line;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine();
		while (line.length() > 1) {
			int sum = 0;
			for (int i = 0; i < line.length(); i++) {
				sum += line.charAt(i) - '0';
			}
			line = Integer.toString(sum);
			count++;
		}
		System.out.println(count);
		if (Integer.parseInt(line) % 3 == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
