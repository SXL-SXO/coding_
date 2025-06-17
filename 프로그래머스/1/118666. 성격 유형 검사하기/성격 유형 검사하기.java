// 04:17
import java.util.*;
class Solution {
    static int N;
    static Map<Character, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public String solution(String[] survey, int[] choices) {
        N = survey.length;
        
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for(int i=0;i<N;i++){
            if(choices[i]<4) map.put(survey[i].charAt(0), map.get(survey[i].charAt(0))+4-choices[i]);
            else map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+choices[i]-4);
        }
        sb.append(map.get('R')>=map.get('T') ? 'R' : 'T');
        sb.append(map.get('C')>=map.get('F') ? 'C' : 'F');
        sb.append(map.get('J')>=map.get('M') ? 'J' : 'M');
        sb.append(map.get('A')>=map.get('N') ? 'A' : 'N');
        
        return sb.toString();
    }
}