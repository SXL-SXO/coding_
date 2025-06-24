import java.util.*;
class Solution {
    static int answer = 0;
    static char input[];
    static Map<Character, Integer> map = new HashMap<>();
    public int solution(String word) {        
        for(int i=0;i<5;i++){
            if(i>=word.length()) word+= ' ';
        }
        
        input = word.toCharArray();
        
        map.put(' ', 0);
        map.put('A', 1);
        map.put('E', 2);
        map.put('I', 3);
        map.put('O', 4);
        map.put('U', 5);
        
        int sum = 1;
        for(int i=4;i>=0;i--){
            if(input[i] != ' ') answer += sum * (map.get(input[i])-1) + 1;
            sum = sum*5+1;
        }
        
        return answer;
    }
}