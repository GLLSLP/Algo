import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_11657_타임머신 {
	static int N,K,start,end,time;
	static int max = Integer.MAX_VALUE;
	static long[] distance;
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());//도시개수
		K=Integer.parseInt(st.nextToken());//버스개수
		distance = new long[N+1];
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			distance[i]=max;
			list[i] = new ArrayList<>();
		}
		for (int k = 0; k < K; k++) {
			st =new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end,time));
		}
		if(bellmanFord()) {
			for (int i = 2; i <= N; i++) {
				System.out.println(distance[i]==max?"-1":distance[i]);
			}
		}else {
			System.out.println(-1);
		}
	}
	
	private static boolean bellmanFord() {
		// TODO Auto-generated method stub
		distance[1]=0;
		boolean check = false;
		for (int n = 1; n <= N; n++) {
			check = false;
			for (int m = 1; m <= N; m++) {
				for (Node node : list[m]) {
					if(distance[m] != max && distance[m]+node.t < distance[node.index]) {
						distance[node.index] = distance[m]+node.t;
						check = true;
					}
				}
			}
			if(!check) {
				break;
			}
		}
		if(check)//순환중일경우
			return false;
		return true;
	}

	static class Node {
		int index;
		int t;
		Node(int index, int t){
			this.index = index;
			this.t = t;
		}
	}
}
