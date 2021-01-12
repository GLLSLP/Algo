import java.util.Arrays;
import java.util.Scanner;

public class Algo2_2 {
	static int V, P, L; // 마을 개수, 경찰서 개수, 큰 길의 둘레
	static int[] input; // 마을 V개의 위치를 저장함
	static int[] choice;// 경찰서 P개의 위치를 저장함
	static int answer = 1000000000; // 출력할 정답
	static int[] ans, temp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			V = sc.nextInt(); // 마을 개수 v
			P = sc.nextInt(); // 경찰서 개수 p
			L = sc.nextInt(); // 원의 길
			input = new int[V]; // V개의 마을의 위치를 저장하는 배열
			choice = new int[P];// P개의 경찰서 위치를 저장하는 배열
			ans = new int[P];
			temp = new int[P];
			for (int j = 0; j < V; j++) { // V개의 정수 좌표..마을의 위치 나타냄
				input[j] = sc.nextInt(); // 마을배열인 input에 저장
			}

			comb(0, 0); // 조합 시작... v개의 마을 중에 경찰서 p개선택
			System.out.println("#" + (i + 1) + " " + answer);	//정답 출력
			for (int j = 0; j < P; j++) {
				System.out.print(ans[j]+" ");
			}
		}
	}

	private static void comb(int cnt, int crr) {	// cnt는 이제까지 고른 개수, crr는 현재 위치
		if (cnt == P) { // 경찰서 P개 선택 끝났으면
			// 마을 하나씩 잡아서 가장 가까운 경찰서 까지의 거리를 구해야 하는데...
			int totalDistance = 0;// 마을 고르기전에 일단 거리 총합 0해두고
			for (int i = 0; i < V; i++) {	//가까운 경찰서까지의 거리를 V개의 마을 각각 다 구해야 하므로 V만큼 for문을 도는데
				if (isIn(input[i])) { // 만약 현재 마을이 경찰서 있는 마을이면 거리는 0이므로 무시한다.
					continue;
				}
				// 경찰서가 없는 마을이면 가장 가까운 경찰서까지의 거리를 구해야 한다.
				int realMin = 1000;	//경찰서 까지의 가장 가까운 거리를 저장할 변수이다.
				for (int j = 0; j < P; j++) { // 각 5개의 경찰서중 1개씩 경찰서씩 고른다.
					//현재 경찰서까지의 가장 가까운 거리를 distance에 저장한다.
					int distance = Math.min(Math.abs(choice[j] - input[i]), L - Math.abs(choice[j] - input[i]));
					//distance들 중 가장 작은 수는 5개의 경찰서까지의 최소 거리이고 realMin에 저장된다.
					realMin = Math.min(realMin, distance);
				}
				totalDistance += realMin; // 현재 마을의 가장 가까운 경찰서 까지의 거리를 totalDistance에 저장한다.
			}
			if(answer>totalDistance) {
				answer = totalDistance;
				for (int i = 0; i < P; i++) {
					ans[i]=choice[i];
				}
			}
//			answer = Math.min(answer, totalDistance);	//totalDistance중 가장 작은것이 선택된다.
			return;
		}
		
		//아직 경찰서 선택을 다 못했으면 마저 더 선택한다.
		for (int i = crr; i < V; i++) {		
			choice[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}

	private static boolean isIn(int t) {
		// 해당 마을이 경찰서가 있는 마을인가?
		for (int j = 0; j < P; j++) {
			if (t == choice[j]) { // 해당마을의 좌표 t가 경찰서들 좌표 중에 있으면
				return true; // true를 반환한다.
			}
		}
		return false;	//그게 아니면 없는것으로 false를 반환한다.
	}

}
