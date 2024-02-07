package 기초;

import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0;i<quiz.length;i++){
            int a;
            String[] aa = quiz[i].split(" ");
            if(aa[1].equals("+")){
                a = Integer.parseInt(aa[0])+Integer.parseInt(aa[2]);
                if (a==Integer.parseInt(aa[4]))
                    answer[i]="O";
                else
                    answer[i]="X";
            }
            if(aa[1].equals("-")){
                a = Integer.parseInt(aa[0])-Integer.parseInt(aa[2]);
                if (a==Integer.parseInt(aa[4]))
                    answer[i]="O";
                else
                    answer[i]="X";
            }            
        }
            
        
        return answer;
    }
}
