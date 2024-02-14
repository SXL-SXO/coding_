import java.io.*;
import java.util.*;

public class 부녀회장이될테야_2775{
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            
            int num = n-1 < k+1 ? com(n+k,n-1) : com(n+k,k+1);
            sb.append(num).append("\n");
        }
        System.out.println("\\"+sb);
    }
    static int com(int n, int k){
        if(n==k) return 1;
        else if(k==0) return 1;
        else if(k==1) return n;
        return com(n-1,k-1)+com(n-1,k);
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int num[][] = new int [100000][14];
        for(int i=0;i<14;i++)
            num[0][i] = i+1;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            
            for(int i=1;i<=k;i++){
                num[i][0] = 1;
                for(int j=1;j<n;j++){
                    num[i][j] = num[i][j-1]+num[i-1][j];
                }
            }
            sb.append(num[k][n-1]).append("\n");
        }
        System.out.println(sb);
    }
}