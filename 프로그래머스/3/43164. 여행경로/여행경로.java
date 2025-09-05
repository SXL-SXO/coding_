// 06:15
import java.util.*;
class Solution {
    static int N, M;
    static boolean fill = false;
    static boolean visit[];
    static String answer[];
    static Map<String, List<Node>> name = new HashMap<>();
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) ->
               o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));
        
        N = tickets.length;
        visit = new boolean[N];
        answer = new String[N+1];
        answer[0] = "ICN";
        
        List<Node> temp;
        for(int i=0;i<N;i++){
            temp = name.getOrDefault(tickets[i][0], new ArrayList<>());
            temp.add(new Node(tickets[i][1], i));
            name.put(tickets[i][0], temp);
        }
        
        dfs("ICN", 1);
        
        return answer;
    }
    static void dfs(String city, int idx){
        if(fill) return;
        else if(idx == N+1) { fill = true; return; }
        else if(!name.containsKey(city)) return;
        
        for(Node n : name.get(city)){
            if(fill) return;
            else if(visit[n.idx]) continue;
            
            visit[n.idx] = true;
            answer[idx] = n.name;
            dfs(n.name, idx+1);
            visit[n.idx] = false;
        }
    }
    static class Node{
        String name;
        int idx;
        Node(String name, int idx){
            this.name = name;
            this.idx = idx;
        }
    }
}