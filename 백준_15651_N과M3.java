import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15651_N과M3 {
static int N,M;
static int [] num;
static StringBuilder sb = new StringBuilder(); //*** 시간초과 방지
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		num = new int[M];
		find(0);
		System.out.println(sb);
	}
	private static void find(int c) {
		// TODO Auto-generated method stub
		if(c==M) {
			for (int i = 0; i < M; i++) {
//				System.out.print(num[i]+" "); //시간초과남
				sb.append(num[i]+" ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			num[c]=i;
			find(c+1);
		}
	}

}
