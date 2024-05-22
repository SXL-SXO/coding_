import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int answer[];
    static int N, L;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        if(L==2){
            if(N%2==1) {
                System.out.println(N / 2 + " " + (N / 2 + 1));
                return;
            }
            else L++;
        }
        int i = L;
        for (; i <= 100; i++) {
            if(i%2==0){
                if((N/i+N/i+1)*i/2==N) {
                    if(i/2-1>N/i) {
                        i = 101;
                        break;
                    }
                    answer = new int[i];
                    answer[i/2-1] = N/i;
                    answer[i/2] = N/i+1;
                    for(int j=0;j<i/2;j++){
                        answer[i/2-j-1] = answer[i/2-j]-1;
                        answer[i/2+j] = answer[i/2+j-1]+1;
                    }
                    break;
                }
            }else{
                if(N%i==0) {
                    if(i/2>N/i) {
                        i = 101;
                        break;
                    }
                    answer = new int[i];
                    answer[i/2] = N/i;

                    for(int j=0;j<i/2;j++){
                        answer[i/2-j-1] = answer[i/2-j]-1;
                        answer[i/2+j+1] = answer[i/2+j]+1;
                    }
                    break;
                }
            }
        }
        if(i>100) sb.append("-1");
        else{
            for(int a:answer) sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}