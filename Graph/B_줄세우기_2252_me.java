package Feb_20;

import java.io.*;
import java.util.*;

public class B_줄세우기_2252_me {
    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int stu[] = new int [N+1];
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0;i<=N;i++){
            input.add(new ArrayList<>());
        }
        int a, b;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            input.get(a).add(b);

            stu[b]+=1;
        }
        for(int i=1;i<=N;i++){
            if(stu[i]==0 ) queue.offer(i);
        }
        int temp_1, temp_2;
        while(!queue.isEmpty()){
            temp_1 = queue.poll();
            sb.append(temp_1).append(" ");
            for(int i=0;i<input.get(temp_1).size();i++){
                temp_2 = input.get(temp_1).get(i);
                stu[temp_2]-=1;
                if(stu[temp_2]==0) {
                    queue.offer(temp_2);
                }
            }
        }
        System.out.println(sb.toString());
        
    }
}
