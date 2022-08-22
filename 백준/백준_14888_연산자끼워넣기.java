import java.util.Scanner;

public class 백준_14888_연산자끼워넣기 {
	static int min = Integer.MAX_VALUE;
	static int max = -Integer.MAX_VALUE;
	static int N;//수의개수
	static int []numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		numbers = new int[N];
		int []operator = new int[4];
		for (int n = 0; n < N; n++) {
			numbers[n]=sc.nextInt();
		}
		for (int o = 0; o < 4; o++) {
			operator[o]=sc.nextInt();
		}
		combination(1, numbers[0], operator);
		System.out.println(max);
		System.out.println(min);
	}
	private static void combination(int numIndex, int total, int[] operator) {
		// TODO Auto-generated method stub
		if(numIndex==N) {//수를 모두 사용했으면
			max = max>total?max:total;
			min = min<total?min:total;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(operator[i]!=0) {
				//현재총값, 연산자인덱스, 다음숫자
				int nextTotal = cal(total, i, numbers[numIndex]);
				operator[i]--;
				combination(numIndex+1,nextTotal,operator);
				operator[i]++;
			}
		}
	}
	private static int cal(int total, int opIndex, int nowNum) {
		// TODO Auto-generated method stub
		if(opIndex==0) {
			//덧셈
			return total + nowNum;
		}else if(opIndex==1) {
			//y셈
			return total - nowNum;
		}else if(opIndex==2) {
			//곱셈
			return total * nowNum;
		}else {
			//나눗셈
			return total / nowNum;
		}

	}

}
