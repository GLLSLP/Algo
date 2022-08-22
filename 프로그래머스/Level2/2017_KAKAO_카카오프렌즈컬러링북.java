class Solution {
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static boolean [][]check;
    static boolean [][]countCheck;
    static int [][]dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int [][]map;
    static int N,M;

    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        check = new boolean[m][n];
        map = new int[m][n];
        M=m;
        N=n;

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                map[i][j]=picture[i][j];
            }
        }


        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==0){
                    check[i][j]=true;
                    continue;
                }
                if(!check[i][j]){
                    countCheck = new boolean[M][N];
                    check[i][j]=true;
                    countCheck[i][j] = true;
                    dfs(i,j,map[i][j]);
                    numberOfArea++;
                    countArea();
                }

            }
        }

        // print(picture,m,n);
        answer[0]=numberOfArea;
        answer[1]=maxSizeOfOneArea;
        return answer;
    }
    static public void countArea(){
        int count = 0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(countCheck[i][j]){
                    count++;
                }
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea,count);
    }
    static public void dfs(int x, int y, int num){
        for(int d=0;d<4;d++){
            int nextX = dir[d][0]+x;
            int nextY = dir[d][1]+y;
            if(nextX<0 || nextX>=M || nextY<0 || nextY>=N){
                continue;
            }
            if(check[nextX][nextY]){
                continue;
            }
            if(map[nextX][nextY]!=num){
                continue;
            }
            check[nextX][nextY]=true;
            countCheck[nextX][nextY]=true;
            dfs(nextX,nextY,num);
        }
    }
    // static public void print(int[][] picture, int m, int n){
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             System.out.print(picture[i][j]);
    //         }
    //         System.out.println();
    //     }
    // }
}