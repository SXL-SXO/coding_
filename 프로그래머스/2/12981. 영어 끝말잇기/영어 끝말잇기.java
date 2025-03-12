// 10:08
import java.util.*;
class Solution {
    static int len, where, leng_a, leng_b;
    static Map<String, Integer> map = new HashMap<>();
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        map.put(words[0],0);
        
        len = words.length;
        leng_b = words[0].length();
        
        if(leng_b == 1) return  new int[]{1, 1};
        
        for(int i=1;i<len;i++){
            leng_a = leng_b;
            leng_b = words[i].length();
            where = map.getOrDefault(words[i], -1);
            
            if(words[i-1].charAt(leng_a-1) == words[i].charAt(0) && where == -1 && leng_b>1) map.put(words[i], 0);
            else {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
        }

        return answer;
    }
}