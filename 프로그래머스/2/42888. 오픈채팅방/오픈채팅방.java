// 10:22 ~ 
import java.util.*;
class Solution {
    static int len;
    static Map<String, String> map = new HashMap<>();
    public String[] solution(String[] s) {
        len = s.length;
        String input[];
        for(String S : s){
            input = S.split(" ");
            if(input[0].charAt(0)=='E') map.put(input[1], input[2]);
            else if(input[0].charAt(0)=='C') {
                map.put(input[1], input[2]);
                len--;
            }
        }
      
        String[] answer = new String[len];
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i=0;i<len;i++){
            input = s[j++].split(" ");
            sb.setLength(0);
            sb.append(map.get(input[1]));
            if(input[0].charAt(0)=='L') sb.append("님이 나갔습니다.");
            else if(input[0].charAt(0)=='E') sb.append("님이 들어왔습니다.");
            else {
                i--;
                continue;
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}