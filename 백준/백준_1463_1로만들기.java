import java.util.Scanner;

public class 백준_1463_1로만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int []count = new int[N+1];
		count[1]=0;
		for (int i = 2; i <= N; i++) {
			count[i]=count[i-1]+1;
			if(i%2==0) {
				count[i]=Math.min(count[i/2]+1, count[i]);
			}
			if(i%3==0) {
				count[i]=Math.min(count[i/3]+1, count[i]);
			}
		}
		System.out.println(count[N]);
	}

}
