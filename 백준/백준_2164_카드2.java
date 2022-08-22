import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_2164_카드2 {
	static Queue<Integer> queue = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N=sc.nextInt();
		for (int n = 1; n <= N; n++) {
			queue.offer(n);
		}
		while(queue.size()>1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		System.out.println(queue.poll());
	}

}
