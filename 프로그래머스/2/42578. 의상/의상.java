// 05:28~
import java.util.*;
class Solution {
    static Map<String, Integer> map = new HashMap<>();
    public int solution(String[][] clothes) {
        int answer = 1, temp;
        
        for(String[] c: clothes){
            temp = map.getOrDefault(c[1], 1) + 1;
            map.put(c[1], temp);
        }
        
        for(String s : map.keySet()){
            answer *= map.get(s);
        }
        
        return answer-1;
    }
}