import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1063_킹 {
	static int[][] map;
	static int kx, ky, sx, sy;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		StringTokenizer st = new StringTokenizer(br.readLine());
		String king = st.nextToken();
		String stone = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		map[(int) (king.charAt(1) - '0')][(int) (king.charAt(0)) - 64] = 1;
		map[(int) (stone.charAt(1) - '0')][(int) (stone.charAt(0)) - 64] = 2;
		kx = (int) (king.charAt(1) - '0');
		ky = (int) (king.charAt(0)) - 64;
		sx = (int) (stone.charAt(1) - '0');
		sy = (int) (stone.charAt(0)) - 64;
		for (int n = 0; n < N; n++) {
			String dir = br.readLine();
			if (dir.equals("R")) {
				move(0, 1);
			} else if (dir.equals("L")) {
				move(0, -1);
			} else if (dir.equals("B")) {
				move(-1, 0);
			} else if (dir.equals("T")) {
				move(1, 0);
			} else if (dir.equals("RT")) {
				move(1, 1);
			} else if (dir.equals("LT")) {
				move(1, -1);
			} else if (dir.equals("RB")) {
				move(-1, 1);
			} else if (dir.equals("LB")) {
				move(-1, -1);
			}
		}
		System.out.print((char) ('A' + ky - 1));
		System.out.println(kx);
		System.out.print((char) ('A' + sy - 1));
		System.out.println(sx);
	}

	private static void move(int x, int y) {
		int nextX = kx + x;
		int nextY = ky + y;
		if (nextX >= 1 && nextX <= 8 && nextY >= 1 && nextY <= 8) {// 킹의 다음 이동이 가능하고
			if (map[nextX][nextY] == 0) {// 돌이 없으면 그냥 이동
				map[kx][ky] = 0;
				map[nextX][nextY] = 1;
				kx = nextX;
				ky = nextY;
			} else {// 돌이 있으면
				if (nextX + x >= 1 && nextX + x <= 8 && nextY + y >= 1 && nextY + y <= 8) {// 돌이 밀어질수 있으면 밀기
					map[nextX + x][nextY + y] = 2;
					map[nextX][nextY] = 1;
					map[kx][ky] = 0;
					kx = nextX;
					ky = nextY;
					sx = nextX + x;
					sy = nextY + y;
				}
			}
		}
	}
}
