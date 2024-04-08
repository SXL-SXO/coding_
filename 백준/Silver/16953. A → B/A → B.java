import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * B_AB_16953
 */
public class Main {
    static int A, B, answer = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        while(B!=A){
            if(B<A){
                answer = -1;
                break;
            }
            else if(B%10==1){
                B/=10;
            }else if(B%2==0){
                B/=2;
            }else{
                answer = -1;
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}