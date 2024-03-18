import java.io.*;
import java.util.*;

public class B_민균이의계략_1168 {
    static int N, max = 0;
    static int card[], answer[];
    static Deque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        card = new int[N];
        answer = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            card[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=0;i<N;i++){
            check(i);
        }
        System.out.println(max);
    }
    static void check(int idx){
        int temp = 0;

        for(int i=idx-1;i>-1;i--){
            if(card[i]<card[idx]){
                temp = Math.max(answer[i],temp);
            }
        }
        answer[idx] = temp+1;
        max = Math.max(answer[idx], max);
    }
}
