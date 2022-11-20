import java.util.*;
class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        for(String[] people : db){
            //System.out.println(people[0]+", "+people[1]);
            //System.out.println(id_pw[0]+", "+id_pw[1]);
            if(people[0].equals(id_pw[0])){
                answer="wrong pw";
                if(people[1].equals(id_pw[1]))
                    answer="login";
                break;
            }
        }
        return answer;
    }
}