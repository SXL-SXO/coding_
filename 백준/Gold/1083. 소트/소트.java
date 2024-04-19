import java.io.*;
import java.util.*;
public class Main {
    static int N, S, start = 0, end, max_v, max_i;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        S = Integer.parseInt(br.readLine());

        while(S>0){
            max_v = -1; max_i = -1;
            end = start+S >= N ? N-1 : start+S;
            
            for(int i=start;i<=end;i++){
                if(max_v<list.get(i)) {
                    max_v = list.get(i);
                    max_i = i;
                }
            }
            if(max_v<0) break;
            list.remove(max_i);
            list.add(start, max_v);
            S -= (max_i-start);
            start++;
        }

        for(int i:list)
            sb.append(i).append(" ");

        System.out.println(sb);
    }
}
