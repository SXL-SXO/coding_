import java.io.*;
public class B_2xN타일링_11726 {
    static int con[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        con = new int[1001][501];
        int answer = 0;
        if(n<=2){
            if(n==1) answer=1;
            else if(n==2) answer=2;

        }else{
            int i=0;
            for(int j=1;j<=n;j++){
                con[j][0] = 1;
                con[j][1] = j;
            }
            while(n-i>=i){
                answer += com(n-i,i++);
            }
        }
        System.out.println(answer%10007);
    }
    static int com(int n, int r){
        if(n-r<r) r = n-r;
        if(con[n][r] == 0){
            if(con[n-1][r-1]!=0 && con[n-1][r]!=0) con[n][r] = con[n-1][r-1] + con[n-1][r];
            else con[n][r] = (com(n-1,r-1) + com(n-1,r))%10007;
            
        }
        return con[n][r]%10007;
    }
}
