import java.util.Scanner;

public class 백준_14891_톱니바퀴 {
	static int[][] gear;
	static boolean [] flag;
	static int K, N, D; //회전횟수, 회전시킨 톱니바퀴 번호, 방향
	static int c=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		gear = new int[5][8];
		
		for (int g = 1; g <= 4; g++) {
			String line = sc.next();
			for (int l = 0; l < line.length(); l++) {
				gear[g][l]=line.charAt(l)-'0';
			}
		}
		K=sc.nextInt();
		for (int k = 0; k < K; k++) {
			flag = new boolean[5];
			c=0;
			N=sc.nextInt();
			D=sc.nextInt();
			System.out.println(k+1+"회차");
			cir(N,D);//번호,방향
			print();
			System.out.println();
		}
		int answer=0;
		for (int g = 1; g <= 4; g++) {
			if(gear[g][0]==1) {
				answer += Math.pow(2, g-1);
			}
		}
		System.out.println(answer);

//		print();
	}

	private static void cir(int num, int direction) {
		// TODO Auto-generated method stub
		//2번인덱스가 오른쪽, 6번 인덱스가 왼쪽이다.
		//direction이 1이면 시계방향, -1이면 반시계방향
		int left = gear[num][6];
		int right = gear[num][2];
		
		if(flag[num]==true) {
			return;
		}else {
			flag[num]=true;
		}
		c++;
		System.out.println("현재돌리는 기어는"+num+"이고 "+left+","+right);
		if(direction==1) {	//시계방향
			System.out.println("시계방향으로 회전한다.");
			int temp = gear[num][7];
			for (int n = 7; n > 0; n--) {
				gear[num][n]=gear[num][n-1];
			}
			gear[num][0]=temp;
			
		}else {	//반시계방향
			System.out.println("반시계방향으로 회전한다.");
			int temp = gear[num][0];
			for (int n = 0; n < 7; n++) {
				gear[num][n]=gear[num][n+1];
			}
			gear[num][7]=temp;
		}
		
		//왼쪽 기어로 재귀 
		if(num>1) {//만약 현재 기어가 제일 왼쪽게 아니면 ㄱㄱ
			if(left!=gear[num-1][2]) {
				//맞닿은곳이 같으면 같은방향 회전이므로 direction은 반대가 된다.
				cir(num-1,direction);
			}
		}
		//오른쪽 기어 재귀
		if(num<4) {//만약 현재 기어가 제일 왼쪽게 아니면 ㄱㄱ
			if(right!=gear[num+1][6]) {
				//맞닿은곳이 같으면 같은방향 회전이므로 direction은 반대가 된다.
				cir(num+1,direction);
			}
		}
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int g = 1; g <= 4; g++) {
			System.out.println();
			for (int l = 0; l < 8; l++) {
				System.out.print(gear[g][l]);
			}
		}
	}

}
