import java.util.Scanner;

public class Algo3_서울_6반_박소현 {
	static int N;
	static int K;
	static int[] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	//치킨집 개수
		K = sc.nextInt();	//집 개수
		map = new int[100000000];	//마을의 길이
		
		for(int n=0;n<N;n++) {				//치킨집 위치 표시하기
			int chicken = sc.nextInt();		
			map[chicken]=1;					//치킨집은 1로 표시한다.
		}
		
	}

}
