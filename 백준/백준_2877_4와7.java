import java.io.*;
import java.util.*;

public class 백준_2877_4와7 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()) + 1;
		StringBuilder sb = new StringBuilder(Integer.toBinaryString(N));
		for (int i = 1; i < sb.length(); i++) {
			if (sb.charAt(i) == '0') {
				bw.write("4");
			} else {
				bw.write("7");
			}
		}
		bw.flush();
		bw.close();
	}

}
