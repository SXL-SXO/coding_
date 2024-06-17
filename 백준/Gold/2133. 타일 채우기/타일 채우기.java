import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int N, answer = 0;
    static int total[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N%2==1) {
            System.out.println(0);
            return;
        }
        N/=2;
        total = new int[N+1];
        total[1] = 3;


//        total[2] = 3;
//        total[4] = total[2]*3 + 2 = 11;
//        total[6] = total[4]*3 + total[2]*2 + 2 = 33+3*2+2 = 41;
//        total[8] = total[6]*3 + total[4]*2 + total[2]*2 + 2 = 41*3 + 82 +;

        for(int i=2; i<=N; i++){
            total[i] = total[i-1]*3+2;
            for(int j=i-2; j>0; j--){
                total[i] += total[j]*2;
            }
        }
        System.out.println(total[N]);
    }
}