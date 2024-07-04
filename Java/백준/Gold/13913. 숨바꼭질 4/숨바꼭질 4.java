import java.util.*;
import java.io.*;
public class Main
{
    static Queue<Integer> queue = new ArrayDeque<>();
    static int N, K;
    static int before[];
    static int count[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N>=K){
            sb.append(N-K).append("\n");
            for(int i=N;i>=K;i--){
                sb.append(i).append(" ");
            }
            System.out.print(sb);
            return;
        }
        
        before = new int[K*2+1];
        count = new int[K*2+1];
        
        queue.offer(N);
        
        int temp;
        before[N] = -1;
        count[N] = 1;
        while(!queue.isEmpty()){
            temp = queue.poll();

            if(temp == K){
                int b = temp;
                for(int j=count[temp]; j>0; j--){
                    sb.insert(0, " ").insert(0, b);
                    b = before[b];
                }
                
                sb.insert(0, "\n").insert(0, count[temp]-1);
                break;
            }
            if(temp!=0 && temp<K && count[temp*2]==0){
                queue.offer(temp*2);
                before[temp*2] = temp; 
                count[temp*2] = count[temp]+1;
            }
            if(temp<K && count[temp+1]==0){
                queue.offer(temp+1);
                before[temp+1] = temp;
                count[temp+1] = count[temp]+1;
            }
            if(temp>0 && count[temp-1]==0){
                queue.offer(temp-1);
                before[temp-1] = temp;
                count[temp-1] = count[temp]+1;
            }
        }
        
        System.out.print(sb);
    }
}
