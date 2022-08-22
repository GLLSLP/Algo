import java.util.Scanner;

public class ����_20055_�����̾Ʈ {
	static int N, K;
	static int[] belt;
	static boolean[] robot;
	static int step = 0;// ��ܰ� ������
	static int ruin = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // ���� Nĭ
		K = sc.nextInt(); // ������ 0�� ĭ�� K�� �̻��̸� ����
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
			// ��Ʈ�̵�
			beltMove();
			// �κ��̵�
			robotMove();
			// �κ��ø���
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
		//�κ��� �Ʒ��ٿ��� �̵��� ���� ����
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
