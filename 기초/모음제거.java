import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = my_string;
        String []aeiou = {"a","e","i","o","u"};
        
        for(String i : aeiou){
            answer=answer.replaceAll(i,"");
        }
        return answer;
    }
}