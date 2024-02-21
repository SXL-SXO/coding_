import java.io.*;

public class 피보나치함수_1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int fi[][] = new int[41][2];
        fi[0] = new int[] {1,0};
        fi[1] = new int[] {0,1};
        for(int t=0;t<T;t++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0) {sb.append(1).append(" ").append(0).append("\n"); continue;}
            else if(temp == 1) {sb.append(0).append(" ").append(1).append("\n"); continue;}
            for(int i=2;i<=temp;i++){
                if(fi[i][0]!=0 || fi[i][1]!=0) continue;
                else{
                    fi[i][0] = fi[i-1][0]+fi[i-2][0];
                    fi[i][1] = fi[i-1][1]+fi[i-2][1];
                }
            }
            sb.append(fi[temp][0]).append(" ").append(fi[temp][1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
