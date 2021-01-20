import java.util.Scanner;

public class ����_14891_��Ϲ��� {
	static int[][] gear;
	static boolean [] flag;
	static int K, N, D; //ȸ��Ƚ��, ȸ����Ų ��Ϲ��� ��ȣ, ����
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
			System.out.println(k+1+"ȸ��");
			cir(N,D);//��ȣ,����
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
		//2���ε����� ������, 6�� �ε����� �����̴�.
		//direction�� 1�̸� �ð����, -1�̸� �ݽð����
		int left = gear[num][6];
		int right = gear[num][2];
		
		if(flag[num]==true) {
			return;
		}else {
			flag[num]=true;
		}
		c++;
		System.out.println("���絹���� ����"+num+"�̰� "+left+","+right);
		if(direction==1) {	//�ð����
			System.out.println("�ð�������� ȸ���Ѵ�.");
			int temp = gear[num][7];
			for (int n = 7; n > 0; n--) {
				gear[num][n]=gear[num][n-1];
			}
			gear[num][0]=temp;
			
		}else {	//�ݽð����
			System.out.println("�ݽð�������� ȸ���Ѵ�.");
			int temp = gear[num][0];
			for (int n = 0; n < 7; n++) {
				gear[num][n]=gear[num][n+1];
			}
			gear[num][7]=temp;
		}
		
		//���� ���� ��� 
		if(num>1) {//���� ���� �� ���� ���ʰ� �ƴϸ� ����
			if(left!=gear[num-1][2]) {
				//�´������� ������ �������� ȸ���̹Ƿ� direction�� �ݴ밡 �ȴ�.
				cir(num-1,direction);
			}
		}
		//������ ��� ���
		if(num<4) {//���� ���� �� ���� ���ʰ� �ƴϸ� ����
			if(right!=gear[num+1][6]) {
				//�´������� ������ �������� ȸ���̹Ƿ� direction�� �ݴ밡 �ȴ�.
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
