import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String t = ")(";
		String answer = separate(t);
        System.out.println(answer);
    }
    
    private static String separate(String line){ //2
        //1
        if(line.equals("")){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        //2
        int x = 0;
        int y = 0;
        for(int i=0;i<line.length();i++){
            if(line.charAt(i)=='('){
                x++;
            }else{
                y++;
            }
            if(x==y){
                String u = line.substring(0,i+1);
                String v = line.substring(i+1,line.length());
                // System.out.println(line+" U:"+u);
                // System.out.println("========");
                if(isOk(u)){ //3
                    String add = separate(v);
                    sb.append(u+add);
                    // System.out.println("여기"+u+"+"+add);
                    break;
                }
                //4

                sb.append("(");
                String add = separate(v);
                sb.append(add);
                sb.append(")");
                String newU = u.substring(1,u.length()-1);
                for(int j=0;j<newU.length();j++){
                    if(newU.charAt(j)=='('){
                        sb.append(")");
                    }else{
                        sb.append("(");
                    }
                }

                break;
            }
        }
        return sb.toString();
    }
    
    private static boolean isOk(String line){
        Stack<Integer> st = new Stack<>();
        boolean fail = false;
        for(int i=0;i<line.length();i++){
            if(line.charAt(i)=='('){
                st.push(1);
            }else{
                if(st.isEmpty()){
                    fail = true;
                    break;
                }
                st.pop();
            }
        }
        if(!st.isEmpty()||fail){
            return false;
        }else{
            return true;
        }
    }
}