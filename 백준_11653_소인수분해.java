import java.util.Scanner;

public class 백준_11653_소인수분해 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N > 1) {
			int n=2;
			while(N!=1) {
				if(N%n==0) {
					System.out.println(n);
					N/=n;
				}else {
					n++;
				}
			}
		}
	}
}
