import java.util.Scanner;
 
public class Main {
	static int[][]dir= {{0,1},{1,0},{0,-1},{-1,0}};
    static int N,M;
    static int[][] map;
    static boolean[][] visit;
    static boolean flag;
    static int[][] melt;
    static int year = 0;
    
    public static void main(String[] args) throws Exception {
    	Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map = new int[N][M];
        visit = new boolean[N][M];
        
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
        
        while(true) {
            melt = new int[N][M];
            check();
            if(flag) {
                break;
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j] > 0) {
                        meltAmount(i,j);
                    }
                }
            }
            melting();
            year++;
            
            if(check3()) {
                break;
            }
        }
        
        if(flag) {
            System.out.println(year);
        } else {
            System.out.println(0);
        }
        
    }
    
    public static void meltAmount(int a, int b) {        
        for(int i=0; i<4; i++) {
            int x = a + dir[i][0];
            int y = b + dir[i][1];
            
            if(x>=0 && x<N && y>=0 && y<M && map[x][y] == 0) {
                melt[a][b] += 1;
            }
        }
    }
    
    public static void melting() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] -= melt[i][j];
                
                if(map[i][j] < 0) {
                    map[i][j] = 0;
                }
            }
        }
    }
    
    public static void check() {
        visit = new boolean[N][M];
        boolean one_dfs_flag = false;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0 && !one_dfs_flag) {
                    one_dfs_flag = true;
                    dfs(i,j);
                    continue;
                }
                
                if(map[i][j] !=0 && !visit[i][j]) {
                    flag = true;
                    return;
                }
            }
        }
    }
    
    public static void dfs(int a,int b) {
        visit[a][b] = true;
        
        for(int i=0; i<4; i++) {
            int x = a + dir[i][0];
            int y = b + dir[i][1];
            
            if(x>=0 && x<N && y>=0 && y<M && !visit[x][y] && map[x][y] != 0) {
                dfs(x,y);
            }
        }
    }
    
    public static boolean check3() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
}