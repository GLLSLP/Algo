import java.util.Scanner;

public class 백준_4811_알약 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		long[] dp = new long[31];
		
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		for (int i = 3; i < 31; i++) {
			long sum=0;
			for (int j = 0; j < i; j++) {
				sum += dp[j]*dp[i-j-1];
			}
			dp[i]=sum;
		}
		while(true) {
			int N=sc.nextInt();
			if(N==0) break;
			System.out.println(dp[N]);
			
		}
	}

}
