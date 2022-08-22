import java.util.Scanner;

public class 백준_1912_연속합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int N=sc.nextInt();
		int []arr = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n]=sc.nextInt();
		}
		long []dp = new long[N];
		dp[0]=arr[0];
		if(N>1) {
			dp[1]=Math.max(dp[0]+arr[1], arr[1]);
		}
		if(N>2) {
			for (int n = 2; n < N; n++) {
				dp[n]=Math.max(dp[n-1]+arr[n], arr[n]);
			}
		}

		long max = Integer.MIN_VALUE;
		for (int n = 0; n < N; n++) {
			max =Math.max(max, dp[n]);
		}
		System.out.println(max);
	}

}
