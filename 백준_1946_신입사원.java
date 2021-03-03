import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_1946_신입사원 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());//테스트케이스수
		for (int t = 0; t < T; t++) {
			int N=Integer.parseInt(br.readLine());//지원자수
			int count =0;
			int [][]human = new int[N][2];
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				human[n][0]=Integer.parseInt(st.nextToken());
				human[n][1]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(human,Comparator.comparing(o->o[0])); //오름차순이 기본
			
			int rank = human[0][1]; //서류 1등의 면접 등수
			for (int i = 0; i < N; i++) {
				if(human[i][1]<=rank) {
					rank = human[i][1];//합격 기준을 바꾸고
					count++;
				}
			}
			System.out.println(count);
		}
		
	}

}
