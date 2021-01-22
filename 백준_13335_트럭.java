import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ����_13335_Ʈ�� {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList();

		int N = sc.nextInt(); // Ʈ���� ����
		int W = sc.nextInt(); // �ٸ� ����
		int L = sc.nextInt(); // �ٸ� �ִ� ����

		int time = 0;//�ð�
		int weight = 0;// �ٸ��� �ִ� Ʈ���� ����
		int[] truck = new int[N]; 

		for (int i = 0; i < N; i++) {
			truck[i] = sc.nextInt();
		} // end of input

		for (int i = 0; i < N; i++) { 
			while (true) {
				if (queue.isEmpty()) {// �ٸ��� �ƹ��͵� ������
					queue.offer(truck[i]);
					time++; 
					weight += truck[i]; 
					break;

				} else if (queue.size() == W) {// ť�� ����� �ٸ��� �����̸�
					weight -= queue.remove();
					
				} else { //�ٸ��� Ʈ���� ���� ��
					if (weight + truck[i]> L) { //���� Ʈ���� ���� + �ٸ��� �ִ� Ʈ���� ���԰� �ִ� ���ߺ��� ũ�ٸ�
						queue.offer(0);
						time++;
					
					} else { //�ִ����ߺ��� �۴ٸ�
						queue.offer(truck[i]);
						time++;
						weight += truck[i];
						break ;

					}
				}
			}
		}
		System.out.println(time+W);

	}// end of main

}
