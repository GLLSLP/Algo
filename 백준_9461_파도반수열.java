import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long []dp =new long[101];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 6; i <= 100; i++) {
			dp[i]=dp[i-1]+dp[i-5];
		}
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(Long.toString(dp[N])+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
