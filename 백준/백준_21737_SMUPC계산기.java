import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 백준_21737_SMUPC계산기 {
	static int N, result, countC;
	static int start, end;
	static boolean inN;//T일땐 숫자받는중
	static char flag=' ';
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		
		for (int l = 0; l < line.length(); l++) {
			char temp = line.charAt(l);
			if(temp>='0' && temp<='9') {//숫자
				if(inN==false) {
					start = l;
					inN=true;
				}
			}else {//기호
				String num="";
				if(inN==true) {
					end=l;
					num = line.substring(start,end);		
					inN=false;
				}

				if(flag==' ') {
					result = Integer.parseInt(num);
				}else if(flag=='S') {
					result -= Integer.parseInt(num);
				}else if(flag=='M') {
					result *= Integer.parseInt(num);
				}else if(flag=='U') {
					result /= Integer.parseInt(num);
				}else if(flag=='P') {
					result += Integer.parseInt(num);
				}
				flag = temp;
				
				if(flag=='C') {
					flag = temp;
				}
				
				if(temp =='C') {
					bw.write(result+" ");
					countC++;
				}
			}
		}
		
		if(countC==0) {
			bw.write("NO OUTPUT");
		}
		bw.flush();
		bw.close();
	}
}
