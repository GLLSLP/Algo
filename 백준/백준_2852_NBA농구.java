import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2852_NBA농구 {
	static int team, before, now, nowMin, nowSec, scoreOne, scoreTwo;
	static int[] time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line = "";
		time = new int[3];
		for (int n = 0; n < N; n++) {
			line = br.readLine();
			team = line.charAt(0) - '0';
			nowMin = (line.charAt(2) - '0') * 10 + line.charAt(3) - '0';
			nowSec = (line.charAt(5) - '0') * 10 + line.charAt(6) - '0';
			now = 60 * nowMin + nowSec;// 현재 시간을 초로 환산
			if (scoreOne > scoreTwo) {// 1팀이 이기고 있었을때
				time[1] += now - before;

			} else if (scoreOne < scoreTwo) {// 2팀이 이기고 있었을때
				time[2] += now - before;

			}
			if (team == 1) {// 점수 올림
				scoreOne++;
			} else {
				scoreTwo++;
			}
			before = now;
		}
		// ***마지막골~경기종료까지
		if (scoreOne > scoreTwo) {
			time[1] += 48 * 60 - before;

		} else if (scoreOne < scoreTwo) {
			time[2] += 48 * 60 - before;

		}

		secToMin(time[1]);
		secToMin(time[2]);

	}

	private static void secToMin(int t) {
		// TODO Auto-generated method stub
		if (t > 0) {
			int min = t / 60;
			int sec = t % 60;
			if (min >= 0 && min < 10) {// ***분과 초가 한자리일때 앞에 0붙이는거 유의
				if (sec >= 0 && sec < 10) {
					System.out.println("0" + min + ":0" + sec);
				} else {
					System.out.println("0" + min + ":" + sec);
				}
			} else {
				if (sec >= 0 && sec < 10) {
					System.out.println(min + ":0" + sec);
				} else {
					System.out.println(min + ":" + sec);
				}
			}
		} else {// ***t가 0이면 나눌수 없으므로 유의
			System.out.println("00:00");
		}

	}

}
