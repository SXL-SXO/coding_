import java.io.*;
import java.util.*;

public class 요세푸스문제_1158 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0, now = K-1;
        ArrayList<Integer>check = new ArrayList<>();
        StringBuilder answer = new StringBuilder("<");
        for(int i=1;i<=N;i++) check.add(i);
        while(count!=N){
            if(now >= check.size()){
                now = now - check.size();
                continue;
            }
            answer.append(check.get(now)).append(", ");
            check.remove(now);
            count+=1;
            now-=1;
            now+=K;
        }
        answer.setLength(answer.length()-2);
        answer.append(">");
        System.out.println(answer.toString());
    }
}