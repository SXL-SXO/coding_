import java.io.*;
import java.util.*;

public class B_케빈베이컨의6단계법칙_1389 {
    static int N, M, answer=0, num=Integer.MAX_VALUE;
    static int dijstra[][];
    static boolean visit[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dijstra = new int[101][101];
        visit = new boolean[101];
        int A,B;
        for(int i=0;i<=100;i++){
            Arrays.fill(dijstra[i],10001);
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            dijstra[A][B]=1;
            dijstra[B][A]=1;
            visit[A] = true;
            visit[B] = true;
        }
        for(int i=1;i<=100;i++){
            if(!visit[i]) continue;
            int result = check(i);
            if(num<=result) continue;
            answer = i;
            num = result;
        }
        System.out.println(answer);
    }
    static int check(int now){
        int size, temp, count=0, time=1;

        Queue<Integer> queue = new ArrayDeque<>();
        for(int j=1;j<=100;j++){
            if(dijstra[now][j]==1) queue.offer(j);
        }
        while(!queue.isEmpty()){
            size = queue.size();
            time++;
            for(int i=0;i<size;i++){
                temp = queue.poll();
                System.out.print(temp+" ");
                if(dijstra[now][temp]>=time) {
                    dijstra[now][temp] = time;
                    dijstra[temp][now] = time;
                }
                for(int j=1;j<=100;j++){
                    if(dijstra[temp][j]!=10001) queue.offer(j);
                }
            }
            System.out.println("");
        }
        for(int i=1;i<=100;i++){
            if(visit[i]) count+=dijstra[now][i];
        }
        return count;
    }
}