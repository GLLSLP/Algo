class Solution {
    static char []members = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char [] arr;
    static boolean [] select;
    static int answer;
    static char[][] datas;//조건들
    static int N, M;
    public int solution(int n, String[] data) {
        answer = 0;
        N=n;
        M=8;//선택멤버수
        datas = new char[n][4];
        for(int i=0;i<n;i++){
            String line = data[i];
            datas[i][0]=line.charAt(0);//A
            datas[i][1]=line.charAt(2);//B
            datas[i][2]=line.charAt(3);//ACT
            datas[i][3]=line.charAt(4);//VALUE
        }
        arr = new char[M];
        select=new boolean[M];

        perm(0);
        return answer;
    }
    public static void perm(int count){
        if(count==M){
            if(isItOk()){
                answer++;
            }
            return;
        }else{
            for(int i=0; i<M; i++){
                if(select[i]){
                    continue;
                }
                arr[count]=members[i];
                select[i]=true;
                perm(count+1);
                select[i]=false;
            }
        }
    }
    public static boolean isItOk(){
        for(int i=0;i<N;i++){//각각의 조건들
            char aName = datas[i][0];
            char bName = datas[i][1];
            int aIndex = 0;
            int bIndex = 0;
            int distance = 0;

            for(int j=0;j<M;j++){//줄선 멤버들
                if(aName==arr[j]){
                    aIndex = j;
                }
                if(bName==arr[j]){
                    bIndex = j;
                }
            }
            distance = Math.abs(aIndex-bIndex)-1;
            boolean flag = false;
            if(datas[i][2]=='='){
                if(distance==datas[i][3]-'0'){
                    flag = true;
                }
            }else if(datas[i][2]=='>'){
                if(distance>datas[i][3]-'0'){
                    flag = true;
                }
            }else if(datas[i][2]=='<'){
                if(distance<datas[i][3]-'0'){
                    flag = true;
                }
            }
            if(!flag){
                return false;
            }
        }
        //모든 조건 통과
        return true;
    }

}