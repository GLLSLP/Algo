import java.util.Scanner;

public class 백준_11727_2xn타일링2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int []dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=3;
		for (int i = 3; i <= n; i++) {
			dp[i]=(dp[i-1]+dp[i-2]*2)%10007;
		}
		System.out.println(dp[n]);
	}

}
