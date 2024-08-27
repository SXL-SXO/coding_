import java.io.*;
import java.util.*;

/**
 * B_회전초밥_15961public class B_회전초밥_15961 {
    static int N, D, K, C, answer;
    static int shusi[];
    static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        shusi = new int[N];
        for(int i=0;i<N;i++){
            shusi[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<K;i++){
            if(shusi[i]!=C) map.put(shusi[i], i);
        }

        int in = K;
        for(int out=0;out<N;out++){
            answer = Math.max(map.size(),answer);
            if(shusi[in]!=C) map.put(shusi[in], in);
            if(shusi[out]!=C && map.get(shusi[out])==out) map.remove(shusi[out]);
            in++;
            if(in==N)in=0;
        }
        System.out.println(answer+1);
        
    }
}
 */

public class Main {
    static int N, D, K, C, answer;
    static int shusi[];
    static int what_copy[];
    
    static Queue<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        shusi = new int[N];
        what_copy = new int [D+1];
        answer = 0;
        int count = 0;
        for(int i=0;i<N;i++){
            shusi[i] = Integer.parseInt(br.readLine());
        }

        what_copy[0] = N+1;        
        int temp;
        for(int i=N-K;i<N;i++){
            temp = shusi[i];
            if (temp == C) temp = 0;
            queue.offer(temp);
            if(what_copy[temp]==0) count+=1;
            what_copy[temp]++;
        }
        answer = count;

        for(int i=0;i<N;i++){
            temp = queue.poll();
            if(temp == C) temp = 0; 
            what_copy[temp]--;
            if(what_copy[temp]==0) count--;

            temp = shusi[i];
            if(temp == C) temp = 0; 
            queue.offer(temp);
            if(what_copy[temp]==0) count++;
            what_copy[temp]++;

            answer = Math.max(answer, count);
        }
        System.out.println(answer+1);
        
    }
}