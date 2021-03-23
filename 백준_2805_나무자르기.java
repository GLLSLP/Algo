import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2805_나무자르기 {
	static int N, M, answer;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 나무 수
		M = Integer.parseInt(st.nextToken());// 필요한 나무 미터
		tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			tree[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		find();

	}

	private static void find() {
		// TODO Auto-generated method stub
		int start = 0;
		int end = tree[N - 1];// ***제일 끝 높이

		while (start <= end) {
			int middle = (start + end) / 2; // 중간 높이
			int temp = 0;// 잘리는 나무 임시로 수집

			for (int i = 0; i < N; i++) {
				if (tree[i] - middle > 0) {
					temp += tree[i] - middle;
				}
			}

			if (temp >= M) {// 충분히 잘랐을 경우
				if (middle > answer) {// 중간높이가 정답보다 클때
					answer = middle + 1;
				}
				start = middle + 1;
			} else {// 자르지 못했을 경우
				end = middle + 1; // **
			}

			System.out.println(answer);
		}
	}

}
