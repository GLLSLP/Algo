import java.util.Scanner;

public class 백준_1837_암호제작 {
	static String P, answer;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		P = sc.next();
		K = sc.nextInt();
		boolean[] nums = new boolean[K + 1];
		nums[1] = true;
		for (int i = 2; i < K; i++) {
			if (nums[i])
				continue;
			if (isAccept(i)) {
				answer = "BAD " + i;
				break;
			}
			for (int j = i + i; j < K; j += i) {
				nums[j] = true;
			}
		}
		if (answer.equals(""))
			answer = "GOOD";
		System.out.println(answer);
	}

	static boolean isAccept(int x) {
		int ret = 0;
		char[] arr = P.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			ret = (ret * 10 + (arr[i] - '0')) % x;
		}
		if (ret == 0) {
			return true;
		} else {
			return false;
		}
	}

}