import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1543_문서검색 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		String word = br.readLine();

		int answer = 0;
		int index = 0;
		int length = doc.length();
		
		for (int i = 0; i < length; i++) {
			if(doc.contains(word)) {
				answer++;
				index = doc.indexOf(word)+word.length(); //다음위치
				doc = doc.substring(index,doc.length());
			}
		}
		System.out.println(answer);
	}

}
