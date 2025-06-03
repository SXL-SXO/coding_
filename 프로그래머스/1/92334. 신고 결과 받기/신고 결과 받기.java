//02:34~
import java.util.*;
class Solution {
    static int N, M, K;
    static int answer[];
    static Map<String, Set<String>> say = new HashMap<>();
    static Map<String, Set<String>> attack = new HashMap<>();
    public int[] solution(String[] id_list, String[] report, int k) {
        N = id_list.length;
        M = report.length;
        K = k;
        
        answer = new int[N];
        
        for(String id : id_list){
            say.put(id, new HashSet<>());
            attack.put(id, new HashSet<>());
        }
        
        String temp[];
        for(String r : report){
            temp = r.split(" ");
            
            say.get(temp[0]).add(temp[1]);
            attack.get(temp[1]).add(temp[0]);
        }
        
        int i = 0;
        for(String id : id_list){
            for(String s : say.get(id)){
                answer[i] += attack.get(s).size() >= K ? 1 : 0;
            }
            i++;
        }
        
        return answer;
    }
}