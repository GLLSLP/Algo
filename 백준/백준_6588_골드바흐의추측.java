import java.util.Scanner;

public class 백준_6588_골드바흐의추측 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		while(true) {
			int N=sc.nextInt();
			if(N==0)
				break;
			find(N);
		}
	}

	private static void find(int n) {
		for (int a = 3; a <= n; a=a+2) {//홀수 돌면서 찾음
			int b = n-a;
			int root = (int)Math.sqrt(a);
			for (int i = 1; i <= root; i++) {
				if(i!=1&&a%i==0) {
					break;
				}else if(a!=1 && i==root) {//a는 소수
					int root2 = (int)Math.sqrt(b);
					for (int j = 1; j <= root2; j++) {
						if(j!=1&&b%j==0) {
							break;
						}else if(b!=1 && j==root2) {//b도 소수
							System.out.println(n+" = "+a+" + "+b);
							return;
						}
					}
				}
			}
		}
	}

}
