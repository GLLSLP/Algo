import java.util.Scanner;

public class Algo2_1_서울_6반_박소현 {
	static int V, P; // 마을개수, 경찰서개수
	static int total; // 조합 가능한 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int i = 0; i < T; i++) {
			total = 0; // 조합 가능한 수...테스트 케이스 돌때마다 0으로 초기화한다.
			V = sc.nextInt(); // 마을 개수
			P = sc.nextInt(); // 경찰서 개수
			comb(0, 0); // 조합 시작
			System.out.println("#" + (i + 1) + " " + total); // 조합 가능한 수 출력
		}
	}

	private static void comb(int cnt, int crr) { // cnt는 이제까지 고른 개수, crr는 현재 위치
		if (cnt == P) { // 만약 경찰서 개수 만큼 선택했으면
			total++; // 조합가능한수 +1한다.
			return;
		}
		for (int i = crr; i < V; i++) { // 아직 조합이 덜되었으면
			comb(cnt + 1, i + 1); // 재귀로 더 선택한다.
		}
	}

}
