import java.io.*;
import java.util.*;

public class 숨바꼭질_1697{
    static boolean check[] = new boolean[100001];
    static int N, K; 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int answer = 0;

        Queue<Integer> num = new LinkedList<>();
        num.offer(N);
        num.offer(-1);

        int temp;
        while(num.size()!=0){
            temp = num.poll();
            if(temp==-1) {
                answer+=1;
                num.offer(-1);
                continue;
            }
            if(temp==K) break;
            if(temp*2<=100000 && !check[temp*2]) {
                check[temp*2]=true;
                num.offer(temp*2);
            }
            if(temp+1<=100000 && !check[temp+1]){
                check[temp+1]=true;
                num.offer(temp+1);
            }
            if(temp>0 && !check[temp-1]){
                check[temp-1]=true;
                num.offer(temp-1);
            }

        }
        System.out.println(answer);
    }
}