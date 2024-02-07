import java.io.*;
import java.util.*;

public class 최단경로 {
    static Map<Integer, ArrayList<int[]>> map = new HashMap<Integer, ArrayList<int[]>>(); 

    static void check_v (int []ans, int start, int cost){
        ArrayList<int[]> link = map.get(start);
        if(link == null) return;
        for(int i=0;i<link.size();i++){
            int[] s= link.get(i);
            if(ans[s[0]] == 0 || ans[s[0]] > s[1] + cost){
                ans[s[0]] = s[1] + cost;
                check_v(ans, s[0], ans[s[0]]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V =Integer.parseInt(st.nextToken());
        int E =Integer.parseInt(st.nextToken());

        int end = Integer.parseInt(br.readLine())-1;
        int []answer = new int[V];
        
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            ArrayList<int[]> abc;
            if(map.containsKey(a)){
                abc = map.get(a);
            } else{
                abc = new ArrayList<int[]>();
            }
            abc.add(new int[] {b,c});
            map.put(a, abc);
        }

        check_v(answer, end, 0);

        for(int j=0;j<V;j++){
            if(j==end) sb.append("0\n");
            else if(answer[j]==0) sb.append("INF\n");
            else {sb.append(answer[j]).append("\n");}
        }

        System.out.print(sb.toString());
    }
}
