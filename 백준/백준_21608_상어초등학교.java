import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_21608_상어초등학교 {
	static int N;
	static int[][] stu;
	static int[][] map;
	static int[][] score;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stu = new int[N * N][5];
		map = new int[N][N];
		for (int n = 0; n < N * N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 5; i++) {
				stu[n][i] = Integer.parseInt(st.nextToken());
			}
		}

		// 첫번째학생은 위치 고정
		map[1][1] = stu[0][0];
		for (int i = 1; i < N * N; i++) {
			score = new int[N][N]; // 학생 하나의 선호 위치
			for (int j = 1; j < 5; j++) {
				findFriend(stu[i][j]);// 이 친구 찾기
			}
			// 점수계산
			int[] good = cal();
			map[good[0]][good[1]] = stu[i][0];// 좋은 자리에 학생번호 앉히기
		}

		// 점수 구하기
		answer();
	}

	private static void answer() {
		// TODO Auto-generated method stub
		int total = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sum = 0;
				// 현재 학생의 정보 인덱스 찾기
				int index = 0;
				for (int t = 0; t < N * N; t++) {
					if (map[i][j] == stu[t][0]) {
						index = t;
					}
				}
				// 친구 몇명있나 세기
				for (int d = 0; d < dir.length; d++) {
					int nx = dir[d][0] + i;
					int ny = dir[d][1] + j;
					if (!isRange(nx, ny)) {
						continue;
					}
					for (int s = 1; s < 5; s++) {
						if (map[nx][ny] == stu[index][s]) {
							sum++;
						}
					}
				}
				// 점수 계산
				if (sum == 1) {
					total += 1;
				} else if (sum == 2) {
					total += 10;
				} else if (sum == 3) {
					total += 100;
				} else if (sum == 4) {
					total += 1000;
				}
			}
		}

		System.out.println(total);
	}

	private static int[] cal() {
		// TODO Auto-generated method stub
		// 최고점 기록---1번조건
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, score[i][j]);
			}
		}

		// 최고점 중복 대비..
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (score[i][j] == max && map[i][j] == 0) { // 최고점을 가진 빈칸 저장
					list.add(new int[] { i, j, zero(i, j) }); // 최고점의 xy좌표(3번조건)과 인근 빈칸수(2번조건)
				}
			}
		}

		// 정렬
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				// 2번조건-빈칸
				if (o1[2] == o2[2]) {// 빈칸수 같으면
					// 3번조건-행렬
					if (o1[0] == o2[0]) {// 행 같으면
						// 열 작은애를 앞으로 보내는 오름차순 정렬
						return Integer.compare(o1[1], o2[1]);
					} else {// 행 다르면
							// 행 작은애를 앞으로 보내는 오름차순 정렬
						return Integer.compare(o1[0], o2[0]);
					}
				} else { // 빈칸수 다르면
					return Integer.compare(o2[2], o1[2]);// 내림차순
				}
			}
		});

		// 정렬 후 1순위 보내기
		return new int[] { list.get(0)[0], list.get(0)[1] };
	}

	private static int zero(int i, int j) {
		int count = 0;
		for (int d = 0; d < dir.length; d++) {
			int nx = i + dir[d][0];
			int ny = j + dir[d][1];
			if (!isRange(nx, ny) || map[nx][ny] != 0) {
				continue;
			}
			count++;
		}
		return count;
	}

	private static void findFriend(int f) {
		// TODO Auto-generated method stub
		// 자리 하나씩 돌기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == f) {// 친구 찾으면
					// 친구 앉은곳 주변 점수 +1
					for (int d = 0; d < dir.length; d++) {
						int nx = dir[d][0] + r;
						int ny = dir[d][1] + c;
						if (!isRange(nx, ny)) {
							continue;
						}
						if (map[nx][ny] != 0) {
							continue;
						}
						score[nx][ny]++;
					}
				}
			}
		}
	}

	static boolean isRange(int x, int y) {
		if (x < 0 || y < 0 || y >= N || x >= N)
			return false;
		return true;
	}

}
