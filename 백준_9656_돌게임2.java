import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_9656_돌게임2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		boolean []dp = new boolean[N+1];
		//true가 상근이가 지는거
		dp[0]=false;
		dp[1]=true;
		for (int i = 1; i <= N; i++) {
			//승부내기
			if(dp[i-1]==false) {
				dp[i]=true;
			}else {
				dp[i]=false;
			}
			
			if(i-3<0) {
				continue;
			}
			if(dp[i-3]==false) {
				dp[i]=true;
			}else {
				dp[i]=false;
			}
			
		}
		if(dp[N]==true) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
	}

}
