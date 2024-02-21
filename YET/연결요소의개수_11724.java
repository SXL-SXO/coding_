import java.io.*;
import java.util.*;

public class 연결요소의개수_11724 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0, count =1;
        int linked[][] = new int [M][2];
        boolean visit[] = new boolean[M];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            linked[i][0]=Integer.parseInt(st.nextToken());
            linked[i][1]=Integer.parseInt(st.nextToken());
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(linked[0]);
        visit[0]=true;
        
        while(count!=M){
            for(int i=0;i<M;i++){
                if(!visit[i]) {queue.offer(linked[i]); break;}
            }
            
            while(!queue.isEmpty()){
                int temp[] = queue.poll();

                for(int i=0;i<M;i++){
                    if(visit[i]) continue;
                    if(linked[i][0]==temp[0]||linked[i][1]==temp[0]||linked[i][0]==temp[1]||linked[i][1]==temp[1]){
                        queue.offer(linked[i]);
                        visit[i]=true;
                        count++;
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
    
}
