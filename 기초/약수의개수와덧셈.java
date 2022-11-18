import java.lang.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<right+1;i++){
            if((int)Math.sqrt((double)i)*(int)Math.sqrt((double)i)==i)
                answer-=i;
            else
                answer+=i;
        }
        return answer;
    }
}