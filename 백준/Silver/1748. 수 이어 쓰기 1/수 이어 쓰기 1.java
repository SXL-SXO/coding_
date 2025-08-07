import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N<10){
            System.out.println(N);
            return;
        }

        long answer = 9, pow = 2;
        while(Math.pow(10, pow)<=N){
            answer += ((long)(Math.pow(10, pow)-Math.pow(10, pow-1)))*pow++;
        }
        answer += ((long)(N-Math.pow(10, pow-1)+1))*pow;

        System.out.println(answer);
    }
}