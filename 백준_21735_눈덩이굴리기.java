import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_21735_눈덩이굴리기 {
	static int N,M,size=1,max;
	static int[]snow;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		snow = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			snow[n]=Integer.parseInt(st.nextToken());
		}
		
		find(1,0,0);
		System.out.println(max);
	}

	private static void find(int size, int index, int time) {
		// TODO Auto-generated method stub
		if(time==M || index==N) {
			max = Math.max(size, max);
		}else {
			if(index<N) {
				find(size +snow[index+1],index+1,time+1);
			}
			if(index<N-1) {
				find(size/2 +snow[index+2],index+2,time+1);
			}	
		}
	}

}
