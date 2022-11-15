import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=0;i<n;i++){
            answer+=1;
            while(true){
                if(answer%3==0||String.valueOf(answer).contains("3"))
                    answer+=1;
                else 
                    break;
            }
        }
        return answer;
    }
}