import java.util.Scanner;

public class 백준_2294_동전2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int []coin = new int[N+1];
		int []dp = new int[K+1];
		for (int i = 0; i <= K; i++) {
			dp[i]=Integer.MAX_VALUE;
		}
		for (int n = 1; n <= N; n++) {
			coin[n]=sc.nextInt();
			dp[coin[n]]=1;
		}
		dp[0]=0;
		dp[1]=1;
		for (int c = 1; c <= N; c++) {
			for (int d = coin[c]; d <= K; d++) {//가장 작은 동전부터
				dp[d]=Math.min(dp[d], dp[d-coin[c]]+1);
			}
		}
		if(dp[K]==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(dp[K]);
		}
	}

}
