import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_3048_개미 {
	static String first,second;
	static ArrayList<Node> arrList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		first=br.readLine();
		second=br.readLine();
		int time = Integer.parseInt(br.readLine());
		
		for (int i = first.length()-1; i >= 0; i--) {
			arrList.add(new Node(first.charAt(i),1));
		}
		for (int i = 0; i < second.length(); i++) {
			arrList.add(new Node(second.charAt(i),2));
		}
		
		while(time-->0) {
			for (int i = 0; i < arrList.size()-1; i++) {
				Node current = arrList.get(i);
				Node next = arrList.get(i+1);
				if(current.num !=2 && current.num != next.num) {
					arrList.set(i,next);
					arrList.set(i+1, current);
					i++;
				}
			}
		}
		for (int i = 0; i < arrList.size(); i++) {
			System.out.print(arrList.get(i).ch);
		}
	}
	public static class Node{
		char ch;
		int num;
		public Node(char ch, int n) {
			this.ch=ch;
			this.num=n;
		}
	}

}
