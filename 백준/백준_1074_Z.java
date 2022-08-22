import java.util.Scanner;

public class 백준_1074_Z {
	static int N, r, c;
	static int[][] dir = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		Z(0, 0, N);
	}

	private static void Z(int x, int y, int n) {
		if (n == 1) {// 제일 작은 z까지 줄어들면
			for (int ri = x; ri <= x + 1; ri++) {
				for (int rj = y; rj <= y + 1; rj++) {
					//count++;
					if (ri == r && rj == c) {
						System.out.println(count);
						return;
					}
					count++;
				}
			}
			return;
		} 
		for (int d = 0; d < 4; d++) {
			int startX = (int) (x + dir[d][0] * Math.pow(2, n - 1));
			int startY = (int) (y + dir[d][1] * Math.pow(2, n - 1));
			int endX = (int) (startX + Math.pow(2, n - 1));
			int endY = (int) (startY + Math.pow(2, n - 1));
			
			if (r >= startX && r < endX && c >= startY && c < endY) {
				Z(startX, startY, n - 1);
				break;
			} else {
				count += Math.pow((startX - endX), 2);
			}

		}
	}

}
