import java.util.Scanner;

public class Algo1 {
	static int X; // 김싸피 보폭
	static int Y; // 박싸피 보폭
	static int H1; // 김싸피 집
	static int H2; // 박싸피 집
	static int answer; // 정답

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt(); // 김싸피 보폭
		Y = sc.nextInt(); // 박싸피 보폭
		H1 = sc.nextInt(); // 김싸피 집
		H2 = sc.nextInt(); // 박싸피 집

		int big = Math.max(H1, H2); // 둘중 더 앞에있는 집
		int small = Math.min(H1, H2); // 둘중 더 뒤에있는 집

		for (int i = big; i <= 10000 + small; i++) { // 더 앞에있는 집부터 ~ 뒤에있는 집+10000미터까지 1m씩 나아간다.
			if ((i - H1) % X == 0 && (i - H2) % Y == 0) { // 만약 그 위치가 김싸피가 뛰어온 거리(i-H1)에서 김싸피의 보폭X을 나눈 나머지가 0이고, 박싸피도 박싸피가 뛰어온 거리(i-H2)에서 박싸피의 보폭Y을 나눈 나머지가 0이면
				answer = i; // 그 위치가 정답이 되므로
				break; // 멈춘다.
			} else {
				answer = -1;// 만약 10000미터 왔는데도 if문에서 걸리지 않으면 정답은 -1이 된다.
			}
		}

		System.out.println(answer); // 정답

	}
}
