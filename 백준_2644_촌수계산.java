import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_2644_촌수계산 {
	static int [][]fam;
	static boolean []check;
	static int []count;
	static int N,one,two,M;
	static Queue<Integer> queue = new LinkedList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		one=sc.nextInt();
		two=sc.nextInt();
		M=sc.nextInt();
		fam = new int[N+1][N+1];
		check = new boolean[N+1];
		count = new int[N+1];
		for (int m = 0; m < M; m++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			fam[a][b]=1;
			fam[b][a]=1;
		}
		bfs();
		if(count[two]==0) {
			System.out.println(-1);
		}else {
			System.out.println(count[two]);
		}
	}
	private static void bfs() {
		queue.add(one);
		check[one]=true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now==two) {
				break;
			}
			for (int i = 1; i <= N; i++) {
				if(fam[now][i]==1 && check[i]==false) {
					queue.add(i);
					check[i]=true;
					count[i]=count[now]+1;
				}
			}
		}
	}
}
