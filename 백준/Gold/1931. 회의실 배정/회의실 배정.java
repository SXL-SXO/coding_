import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int answer = 0;

        PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->( o1[1]==o2[1] ? (o1[1]-o1[0])-(o2[1]-o2[0]) : o2[1]-o1[1]));

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            pqueue.offer(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }
        int end[] = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int temp[] = new int[2];
        for(int j=0;j<N;j++){
            temp = pqueue.poll();
            if(end[0]<temp[0]) {end[0] = temp[0]; end[1] = temp[1]; continue;}
            if(end[0]<temp[1]) continue;
            //System.out.println(temp[0]+" "+temp[1]);
            answer+=1;
            end[0] = temp[0]; 
            end[1] = temp[1];
        }
        System.out.println(answer);
    }
}
