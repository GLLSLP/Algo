package com.breakwall;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][][] visit;	//첫칸은 벽을안부수고이동/하나부수고이동을 분리
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[2][N][M];
		
		for(int n=0;n<N;n++) {
			String line = sc.next();
			for(int m=0;m<M;m++) {
				map[n][m]=line.charAt(m)-'0';
			}
		}
		
		bfs();
		
		if(answer==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
		
		
	}
	
	
	private static void bfs() {
		// TODOQueue<E>-generated method stub
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0,0,1,0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int y = node.y;
			int x = node.x;
			int count = node.count;
			int destroy = node.destroy;
			
			if(y==N-1 && x==M-1) {	//도착했을때
				answer = Math.min(answer, count);
				continue;
			}
			
			for(int i=0;i<4;i++) {
				int nextY = y+dir[i][0];
				int nextX = x+dir[i][1];
				
				if(nextY>=0&&nextY<N&&nextX>=0&&nextX<M) {
					if(destroy==1) {	//이미 벽 하나 부쉈을때
						//방문한적없고 걸어 지나갈수 있을때
						if(!visit[destroy][nextY][nextX]&&map[nextY][nextX]==0) {
							visit[destroy][nextY][nextX]=true;
							q.add(new Node(nextY,nextX,count+1,destroy));
						}
					}else {				//아직 벽 안부쉈을때
						
						if(map[nextY][nextX]==1) {	//벽이면
							//
							if(!visit[destroy+1][nextY][nextX]) {
								visit[destroy+1][nextY][nextX]=true;
								q.add(new Node(nextY, nextX, count+1, destroy+1));
							}
						}else if(map[nextY][nextX]==0) {	//길이면
							if(!visit[destroy][nextY][nextX]) {
								visit[destroy][nextY][nextX]=true;
								q.add(new Node(nextY, nextX, count+1, destroy));
							}
						}
					}
					
				}
			}
		}
	}

}

class Node {
    int y;
    int x;
    int count;
    int destroy;
    public Node(int y, int x, int count, int destroy) {
        super();
        this.y = y;
        this.x = x;
        this.count = count;
        this.destroy = destroy;
    }
 
}
