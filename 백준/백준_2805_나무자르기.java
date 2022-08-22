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
		Arrays.sort(tree); //작->큰으로 정렬

		System.out.println(find());

	}

	private static int find() {
		// TODO Auto-generated method stub
		int start = 0;
		int end = tree[N - 1];// ***제일 끝 높이
		int middle = 0;

		while (start <= end) {
			middle = (start + end) / 2; // 중간 높이
			long temp = 0;// 잘리는 나무 임시로 수집... ****long 필수!!!!****

			for (int i = 0; i < tree.length; i++) {
				if (tree[i] > middle) {
					temp += tree[i] - middle;
				}
			}

			if (temp >= M) {// 충분히 잘랐을 경우
				if (middle > answer) {//과다
					answer = middle;//과다중에 가장 높은 톱질높이를 저장
				}
				start = middle + 1; //시작점을 올림 = middle(톱질높이) 높아지게함 = 적게잘림
			} else {//부족
				end = middle - 1; // 끝점을 줄임 = middle(톱질높이) 낮아짐 = 많이잘림
			}
		}

		return answer;
	}

}
