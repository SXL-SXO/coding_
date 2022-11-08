package 기초;

import java.util.*;

class Solution {
    public String solution(int age) {
        String answer = "";
        for(int i=0;i<4;i++){
            int a = (int)(age/Math.pow(10,3-i));
            if(a==0&&answer.length()==0)
                continue;
            char temp = (char)(a+97);
            age=age-a*(int)Math.pow(10,3-i);
            answer=answer+temp;
        }
        return answer;
    }
}
