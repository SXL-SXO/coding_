// 10:21
import java.util.*;
class Solution {
    static int N, M, M_M, answer = 0;
    static Map<String, List<Integer>> map = new HashMap<>();
    static Map<String, List<Integer>> possible_id = new HashMap<>();
    static List<String> banned_id = new ArrayList<>();
    static char input_u[][], input_b[][];
    static boolean visit[];
    static String user_id[], b_id[];
    public int solution(String[] u, String[] b) {
        user_id = u;
        b_id = b;
        
        N = user_id.length;
        M = b_id.length;
        
        for(int i=0;i<M;i++) {
            map.put(b_id[i], map.getOrDefault(b_id[i], new ArrayList<>()));
            map.get(b_id[i]).add(i);
        }
        M_M = map.size();
        for(String s :map.keySet()) banned_id.add(s); 
        
        input_u = new char[N][];
        input_b = new char[M_M][];
        for(int i=0;i<N;i++) input_u[i] = user_id[i].toCharArray();
        for(int j=0;j<M_M;j++) {
            input_b[j] = banned_id.get(j).toCharArray();
            possible_id.put(banned_id.get(j), new ArrayList<>());
        }
        
        for(int j=0;j<M_M;j++){
            for(int i=0;i<N;i++){
                if(user_id[i].length() != banned_id.get(j).length()) continue;
                check(i, j);
            }
        }
        
        visit = new boolean[(int)Math.pow(2, 9)];
        for(int a: possible_id.get(b_id[0])){
            make(1, 1<<a);
        }
        
        for(int i=0;i<Math.pow(2, 9);i++) if(visit[i]) answer++;
        return answer;
    }
    static int cal(int c){
        int res = 1;
        for(int i=c;i>0;i--) res*=i;
        return res;
    }
    static void make(int idx, int disit){
        if(idx == M){
            visit[disit] = true;
            return;
        }
        
        for(int a: possible_id.get(b_id[idx])){
            if((disit & (1<<a)) != 0) continue;
            make(idx+1, disit|(1<<a));
        }
    }
    static void check(int i, int j){
        int len = banned_id.get(j).length();
        for(int k=0;k<len;k++){
            if(input_b[j][k]=='*') continue;
            else if(input_u[i][k]!=input_b[j][k]) return;
        }
        possible_id.get(banned_id.get(j)).add(i);
    }
    
}