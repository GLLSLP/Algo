import java.io.*;
import java.util.*;

public class Main {
	static int V, E, P;
	static boolean save;
	static int[] dis;
	static ArrayList<Dot>[] list;
	static PriorityQueue<Dot> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dis = new int[V + 1];
		list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Dot(b, c));
			list[b].add(new Dot(a, c));
		}

		if (P == 1) {
			bw.write("SAVE HIM");
		} else {
			int all = Dijkstra(1, V);
			int oneToP = Dijkstra(1, P);
			int PToV = Dijkstra(P, V);

			if (all >= oneToP + PToV) {
				bw.write("SAVE HIM");
			} else {
				bw.write("GOOD BYE");
			}
		}

		bw.flush();
		bw.close();
	}

	private static int Dijkstra(int start, int end) {

		pq = new PriorityQueue<>();
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;

		pq.offer(new Dot(start, 0));
		while (!pq.isEmpty()) {
			Dot now = pq.poll();
			for (Dot next : list[now.node]) {
				if (dis[next.node] >= dis[now.node] + next.w) {
					dis[next.node] = dis[now.node] + next.w;
					pq.offer(new Dot(next.node, dis[next.node]));
				}
			}
		}
		return dis[end];
	}

}

class Dot implements Comparable<Dot> {
	int node;
	int w;

	public Dot(int node, int w) {
		this.node = node;
		this.w = w;
	}

	@Override
	public int compareTo(Dot o) {
		return this.w - o.w;
	}
}
