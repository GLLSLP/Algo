import java.util.*;

class Solution {
    static String[][] arr;
    static HashMap<String,String> map;
    public String[] solution(String[] record) {
        String[] answer;
        StringTokenizer st;
        arr = new String[record.length][2];
        map = new HashMap<>();
        int lineCount = 0;
        for(int i=0;i<record.length;i++){
            String line = record[i];
            st =new StringTokenizer(line);
            String act = st.nextToken();
            String uid = st.nextToken();
            if(act.equals("Enter")){
                String name = st.nextToken();
                if(map.get(uid)==null){
                    map.put(uid,name);
                }else{
                    map.replace(uid,name);
                }
                lineCount++;
                arr[i][0]=act;
                arr[i][1]=uid;
            }else if(act.equals("Change")){
                String name = st.nextToken();
                map.replace(uid,name);
                arr[i][0]=act;
                arr[i][1]=uid;
            }else{
                arr[i][0]=act;
                arr[i][1]=uid;
                lineCount++;
            }

        }
        answer = new String[lineCount];
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i][0].equals("Change")){
                continue;
            }else if(arr[i][0].equals("Enter")){
                answer[index]=map.get(arr[i][1])+"님이 들어왔습니다.";
            }else{
                answer[index]=map.get(arr[i][1])+"님이 나갔습니다.";
            }
            index++;
        }

        return answer;
    }
}