import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    static int N, top, bottom, ans = 0;
    static int input[][];

    static boolean number[] = new boolean[7];
    static int answer[] = new int[7];

    static int set[] = {5,3,4,1,2,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        input = new int[N][6];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= 6; i++){
            top = i;
            check(0, i);
//            System.out.println("");
            ans = Math.max(answer[i], ans);
        }
        System.out.println(ans);
    }
    static void check(int count, int start){
        if(count == N){
            return;
        }

        bottom = top;
        for(int i=0;i<6;i++){
            if(input[count][i]==bottom){
                top = input[count][set[i]];
                break;
            }
        }

        Arrays.fill(number, false);
        number[bottom] = true;
        number[top] = true;
        for(int i = 6; i > 0; i--){
            if(!number[i]) {
                answer[start] += i;
//                System.out.print(bottom+" "+top+" "+i+" / ");
                break;
            }
        }
        check(count+1, start);
    }
}