import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] list = my_string.split(" ");
        answer=Integer.parseInt(list[0]);
        for(int i=0; i<list.length-1; i++){
            if((list[i].equals("-")&&list[i+1].equals("+"))||(list[i].equals("-")&&list[i+1].equals("+"))){
                answer-=Integer.parseInt(list[i+2]);
                i++;
            }
            else if(list[i].equals("-")&&list[i+1].equals("-")){
                answer+=Integer.parseInt(list[i+2]);
                i++;
            }
            else if(list[i].equals("-"))
                answer-=Integer.parseInt(list[i+1]);
            else if(list[i].equals("+"))
                answer+=Integer.parseInt(list[i+1]);
        }
        return answer;
    }
}
