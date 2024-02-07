
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String num[] = s.split(" ");
        Stack<Integer> plus = new Stack<>();
        
        for(String i:num){
            //System.out.print(i);
            if(i.equals("Z") && plus.size()!=0)
                plus.pop();
            else
                plus.push(Integer.parseInt(i));
        }
        for(int j:plus){
            answer+=j;
        }
        return answer;
    }
}