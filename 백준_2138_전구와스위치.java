import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ����_2138_�����ͽ���ġ {
static int N;
static int min;
static char [][]before;
static char []after;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//before�� �ΰ��� ���� ����
		before = new char[2][N];
		after = new char[N];
		String line = br.readLine();
		before[0] = line.toCharArray();
		before[1] = line.toCharArray();
		//after ����
		line = br.readLine();
		after = line.toCharArray();
		min = Integer.MAX_VALUE;
		//0�� ����ġ �ȴ����� ����
		go(1,0,0);
		//0�� ����ġ ������ ����
		push(0,1);
		go(1,1,1);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	private static void go(int index, int count, int type) {
		// TODO Auto-generated method stub
		if(index==N) {
			//������ ������
			if(before[type][index-1]==after[index-1]) {
				min=min>count?count:min;
				return;
			}
			if(before[type][index-1]!=after[index-1]) {
				//���� ���� ������
				//��ư ������
				push(index,type);
				//���� �ε����� �̵�
				go(index+1,count+1,type);
			}else {
				//������ ��ư �ȴ����� ���� �ε����� �̵�
				go(index+1,count,type);
			}
		}
	}
	private static void push(int index, int type) {
		// TODO Auto-generated method stub
		for (int i = index-1; i <= index+1; i++) {
			if(i>=0&&i<N) {	//�ε����� ���� �ȿ� ������
				before[type][i]=before[type][i]=='1'?'0':'1';
			}
		}
	}


}
