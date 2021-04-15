import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_5525_IOIOI {
	static int N,M;
	static String S, P;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		S=br.readLine();
		int i = 1;
		int answer = 0;
		int count = 0;
		while(i<M-1) {
			if(S.charAt(i-1)=='I'&&S.charAt(i)=='O'&&S.charAt(i+1)=='I') {
				count++;
				if(count==N) {
					answer++;
					count--;
				}
				i = i+2;
			}else {
				count=0;
				i++;
			}
		}
		System.out.println(answer);
	}

}
