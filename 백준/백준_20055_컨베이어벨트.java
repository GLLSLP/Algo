import java.util.Scanner;

public class 백준_20055_컨베이어벨트 {
	static int N, K;
	static int[] belt;
	static boolean[] robot;
	static int step = 0;// 몇단계 진행중
	static int ruin = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 가로 N칸
		K = sc.nextInt(); // 내구도 0인 칸이 K개 이상이면 종료
		belt = new int[2 * N+1];
		robot = new boolean[2 * N+1];
		for (int n = 1; n <= 2 * N; n++) {
			belt[n] = sc.nextInt();
			if(belt[n]==0) {
				ruin++;
			}
		}

		while (ruin<K) {
			step++;
			// 벨트이동
			beltMove();
			// 로봇이동
			robotMove();
			// 로봇올리기
			up();
			
		}
		System.out.println(step);

	}


	private static void up() {
		if(!robot[1]&&belt[1]>0) {
			robot[1]=true;
			belt[1]--;
			if(belt[1]==0) {
				ruin++;
			}
		}
	}


	private static void robotMove() {
		//로봇이 아랫줄에서 이동할 경우는 없다
		if(robot[N]) {
			robot[N]=false;
		}
		for (int i = N-1; i > 0; i--) {
			if(robot[i]&&belt[i+1]>0&&robot[i+1]==false) {
				robot[i]=false;
				robot[i+1]=true;
				belt[i+1]--;
				if(belt[i+1]==0) {
					ruin++;
				}
			}
		}
		if(robot[N]) {
			robot[N]=false;
		}
	}

	private static void beltMove() {
		int temp = belt[2*N];
		for (int i = 2*N; i > 1; i--) {
			robot[i] = robot[i - 1];
			belt[i] = belt[i - 1];
		}
		belt[1] = temp;
		robot[1] = false;
	}

}
