import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int count = 1;
		for (int i = 1; i < line.length(); i++) {
			count++;
			if (line.charAt(i) == 'j') {
				if (line.charAt(i - 1) == 'n' || line.charAt(i - 1) == 'l') {
					count--;
				}
			} else if (line.charAt(i) == '=') {
				if (line.charAt(i - 1) == 's' || line.charAt(i - 1) == 'c') {
					count--;
				} else if (line.charAt(i - 1) == 'z' && i > 1 && line.charAt(i - 2) == 'd') {
					count = count - 2;
				} else if (line.charAt(i - 1) == 'z') {
					count--;
				}
			} else if (line.charAt(i) == '-') {
				if (line.charAt(i - 1) == 'c' || line.charAt(i - 1) == 'd') {
					count--;
				}
			}
		}
		System.out.println(count);

	}

}
