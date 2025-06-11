// 07:51
import java.util.*;

class Solution {
    static int N;
    static String answer[];
    static Map<String, String> map = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        N = players.length;
        
        answer = new String[N];
        for(int i=0;i<N;i++){
            map.put(players[i], String.valueOf(i));
            map.put(String.valueOf(i), players[i]);
        }
        
        int rank;
        String winner;
        for(String c : callings){
            rank = Integer.parseInt(map.get(c));
            winner = map.get(String.valueOf(rank-1));
            map.put(winner, String.valueOf(rank));
            map.put(String.valueOf(rank), winner);
            map.put(c, String.valueOf(rank-1));
            map.put(String.valueOf(rank-1), c);
        }
        
        for(int i=0;i<N;i++){
            answer[i] = map.get(String.valueOf(i));
        }
        return answer;
    }
}