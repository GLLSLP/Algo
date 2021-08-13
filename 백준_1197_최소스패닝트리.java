import java.io.*;
import java.util.*;

public class Main {
	static int V, E, answer;
	static ArrayList<Dot> list = new ArrayList<Dot>();
	static int[] union;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list.add(new Dot(A, B, C));
		}

		// 1.우선 자신의 root를 자기 자신으로
		union = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			union[i] = i;
		}

		// 2. 가중치 작은 순서로 고르기 위해 정렬
		Collections.sort(list);

		// 3. 가중치 구하기
		for (int e = 0; e < E; e++) {
			int u = list.get(e).u;
			int v = list.get(e).v;

			// 각 정점 u, v의 부모 rU, rV를 찾음
			int rU = root(u);
			int rV = root(v);
			// 두 정점의 부모가 다르면 연결시킨다음 한쪽을 다른한쪽의 부모로 함
			if (rU != rV) {
				union[rV] = rU;
				answer += list.get(e).w;
			}
		}
		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}

	private static int root(int num) {
		if(num==union[num]) { //부모정점일때
			return num;
		}else {
			return union[num]=root(union[num]);
		}
	}

}

class Dot implements Comparable<Dot> {
	int u;
	int v;
	int w;

	public Dot(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Dot o) {
		return this.w - o.w;
	}
}
