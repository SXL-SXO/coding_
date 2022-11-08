import java.util.*;
class Solution {
    public int solution(int[] common) {
        int answer = 0;
        if((common[2]-common[1])==(common[1]-common[0]))
            answer=common[0]+common.length*(common[1]-common[0]);
        else
            answer=common[0]*(int)Math.pow(common[2]/common[1],common.length);
        return answer;
    }
}