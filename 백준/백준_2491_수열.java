package som.sequence2491;

import java.util.Scanner;

public class Main {
	static int len;
	static int[] num;
	static int max = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		len = sc.nextInt();
		num = new int[len];
		for (int i = 0; i < len; i++) {
			num[i] = sc.nextInt();
		}

		int upcount = 1;
		for (int i = 1; i < len; i++) {
			if (num[i - 1] <= num[i]) {
				upcount++;
			} else {
				upcount = 1;
			}
			if(max<upcount) {	//왠진 모르겠는데 math.max쓰면 틀림;;
				max = upcount;
			}
		}
		
		int downcount = 1;
		for (int i = 1; i < len; i++) {
			if (num[i - 1] >= num[i]) {
				downcount++;
			} else {
				downcount = 1;
			}
			if(max<downcount) {
				max=downcount;
			}
		}
		
		
		System.out.println(max);
	}
}