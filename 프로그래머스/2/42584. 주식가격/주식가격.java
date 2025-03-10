// 시작시간 3/7 16:14~52 , 3/10 17:07
import java.util.*;
class Solution {
    static int len;
    static int input[], answer[];
    static Stack<Integer> stack = new Stack<>();
    public int[] solution(int[] in) {
        len = in.length;
        
        input = in;
        answer = new int[len];
            
        for(int i=1;i<len;i++){
            if(input[i-1]>input[i]) check(i-1);
        }
        for(int i=0;i<len;i++) if(answer[i]==0) answer[i] = len-1-i;
        return answer;
    }
    static void check(int idx){
        int i=idx-1;
        for(;i>=0;i--){
            if(input[i]<=input[idx+1]) break;
        }
        i++;
        for(;i<=idx;i++){
            if(answer[i]==0) answer[i] = idx-i+1;      
        }
    }
}