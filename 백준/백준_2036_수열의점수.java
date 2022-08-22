import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class 백준_2036_수열의점수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		BigInteger answer = new BigInteger("0");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			if (arr[i] > 0) {
				break;
			} else if (i + 1 == N) { // 배열 끝일때
				answer = answer.add(BigInteger.valueOf(arr[i]));
				break;
			} else if (arr[i] * arr[i + 1] >= 0) { // 주의점 : >0이 아니라 >=0이다....젠장
				answer = answer.add(BigInteger.valueOf(arr[i] * arr[i + 1]));
				i++;
				continue;
			} else { // 다음번이 양수면 arr[i](=절대값이 가장 작은 음수)를 답에 더함
				answer = answer.add(BigInteger.valueOf(arr[i]));
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] < 0) {
				break;
			} else if (i == 0) { // 배열 끝일때
				answer = answer.add(BigInteger.valueOf(arr[i]));
				break;
			} else if (arr[i] * arr[i - 1] > 0 && arr[i] * arr[i - 1] > arr[i] + arr[i - 1]) { // 곱해서 더한게 더 클때
				answer = answer.add(BigInteger.valueOf(arr[i] * arr[i - 1]));
				i--;
				continue;
			} else { // 더한게 더 클때 = arr[i]가 1일때
				answer = answer.add(BigInteger.valueOf(arr[i]));
			}
		}
		System.out.println(answer);
	}

}
