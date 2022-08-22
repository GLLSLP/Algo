import java.util.Scanner;
public class 백준_1929_소수구하기 {
    public static void main(String [] args){
        int M, N, root;
        Scanner scan = new Scanner(System.in);
        M= scan.nextInt();
        N= scan.nextInt();
        for(int i=M; i<=N; i++) { //i=2; root=1; j=1
            root=(int)Math.sqrt(i); //i=1; root=1; j=1
            for(int j=1; j<=root; j++) {
                if(j!=1&&i%j==0) {
                    break;
                }else if(i!=1&&j==root){
                    System.out.println(i);
                }
            }
        }
    }
}
