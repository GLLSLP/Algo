import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		while (true) {
			if (N % 5 == 0) {
				answer += N / 5;
				break;
			}
			N -= 3;
			answer++;
			if (N < 0) {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);
	}
}
