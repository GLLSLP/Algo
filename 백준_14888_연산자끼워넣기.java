import java.util.Scanner;

public class ����_14888_�����ڳ����ֱ� {
	//static int min = Integer.MAX_VALUE;
	//static int max = -Integer.MAX_VALUE;
    static int max=-1000000000, min=1000000000;
	static int N;//���ǰ���
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
		if(numIndex==N) {//���� ��� ���������
			max = max>total?max:total;
			min = min<total?min:total;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(operator[i]!=0) {
				//�����Ѱ�, �������ε���, ��������
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
			//����
			return total + nowNum;
		}else if(opIndex==1) {
			//�y��
			return total - nowNum;
		}else if(opIndex==2) {
			//����
			return total * nowNum;
		}else {
			//������
			return total / nowNum;
		}

	}

}
