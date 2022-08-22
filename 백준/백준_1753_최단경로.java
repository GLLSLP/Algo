import java.io.*;
import java.util.*;

public class Main {
	static int V, E, K;
	static int[] shortestPath;
	static PriorityQueue<Dot> pq;
	static ArrayList<Dot>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());// 정점 개수
		E = Integer.parseInt(st.nextToken());// 간선 개수
		K = Integer.parseInt(br.readLine());// 시작정점 번호

		shortestPath = new int[V + 1];
		Arrays.fill(shortestPath, Integer.MAX_VALUE);
		shortestPath[K] = 0;

		pq = new PriorityQueue<>();
		list = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Dot(v, w));
		}

		Dijkstra();

		StringBuilder sb = new StringBuilder();
		for (int v = 1; v <= V; v++) {
			if (shortestPath[v] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(shortestPath[v] + "\n");
			}
		}
		bw.write(sb.toString());

		bw.flush();
		bw.close();
	}

	private static void Dijkstra() {
		// TODO Auto-generated method stub
		pq.offer(new Dot(K, 0));
		while (!pq.isEmpty()) {
			Dot now = pq.poll();

			for (Dot next : list[now.node]) {
				if (shortestPath[next.node] > shortestPath[now.node] + next.weight) {
					shortestPath[next.node] = shortestPath[now.node] + next.weight;
					pq.offer(new Dot(next.node, shortestPath[next.node]));
				}
			}
		}
	}

}

class Dot implements Comparable<Dot> {
	int node;
	int weight;

	Dot(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}

	@Override
	public int compareTo(Dot o) {
		return this.weight - o.weight;
	}
}