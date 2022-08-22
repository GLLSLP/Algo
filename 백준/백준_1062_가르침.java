import java.util.*;
import java.io.*;

public class Main {
	static int N, K, answer;
	static String [] word;
	static boolean [] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		word = new String[N];
		check = new boolean[26];
		check['a'-97]=check['n'-97]=check['t'-97]=check['c'-97]=check['i'-97]=true;
		
		//기본 5개 = antci
		if(K<5) {
			answer = 0;
		}else {
			K=K-5;
			for (int n = 0; n < N; n++) {
				String line = br.readLine();
				word[n]=line.substring(4,line.length()-4);
			}
			comb(0,0);
		}

		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
	private static void comb(int count, int index) {
		// TODO Auto-generated method stub
		if(K==count) {
			answer = Math.max(answer, getAnswer());
			return;
		}
		for (int i = index; i < 26; i++) {
			if(check[i]) {
				continue;
			}
			check[i]=true;
			comb(count+1,i+1);
			check[i]=false;
		}
		
	}
	private static int getAnswer() {
		int count = 0;
		boolean flag = true;
		for(String line : word) {
			flag = true;
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if(!check[c-97]) {
					flag=false;
					break;
				}
			}
			if(flag) {
				count++;
			}
		}
		return count;
	}



}