import java.io.*;
import java.util.*;

public class B_민균이의계략_11568 {
    // static int N, answer=0;
    // static int card[];
    // static Deque<Integer> stack = new ArrayDeque<>();
    // public static void main(String[] args) throws Exception {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st;
    //     N = Integer.parseInt(br.readLine());
    //     card = new int[N];
    //     st = new StringTokenizer(br.readLine());
    //     for(int i=0;i<N;i++){
    //         card[i] = Integer.parseInt(st.nextToken());
    //     }

    //     check(0);
    //     stack.push(card[0]);
    //     check(0);

    //     System.out.println(answer);
    // }
    // static void check(int idx){
    //     if(idx == N){
    //         answer = Math.max(answer, stack.size());
    //         return;
    //     }
    //     check(idx+1);
    //     if(stack.size()==0||stack.peek()<card[idx]) {
    //         stack.push(card[idx]);
    //         check(idx+1);
    //         stack.pop();
    //     }
    // }
    static int N, answer=0;
    static int card[], dp[][];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        card = new int[N];
        dp = new int[2][N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        check(N-1);
    }
    static void check(int idx){
        if(idx==N-1)
    }
}
