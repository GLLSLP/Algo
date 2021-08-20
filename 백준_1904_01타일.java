import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int []dp =new int[N+1];
		dp[0]=1;
		dp[1]=1;
		if(N>1) {
			for (int i = 2; i <= N; i++) {
				dp[i]=(dp[i-1]+dp[i-2])%15746;
			}
		}
		bw.write(Integer.toString(dp[N]));
		bw.flush();
		bw.close();
	}

}
