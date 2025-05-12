// 11:18
import java.util.*;
class Solution {
    static int input[], answer[] = new int[2];
    static int N, K;
    public int[] solution(int[] sequence, int k) {
        input = sequence;
        K = k;
        N = input.length;
        
        answer[0] = 0;
        answer[1] = N-1;
        
        int start = 0, end = 0, sum = input[0];
        while(end<N-1){
            // System.out.println(start+" "+end+" "+sum);
            if(sum<K) sum += input[++end];
            else if(sum>K) sum -= input[start++];
            else{
                if(answer[1]-answer[0] > end-start){
                    answer[0] = start;
                    answer[1] = end;
                }
                sum += input[++end];
                sum -= input[start++];
            }
        }        
        
        while(sum>=K && start<N){
            // System.out.println(start+" "+end+" "+sum);
            if(sum==K){
                if(answer[1]-answer[0] > end-start){
                    answer[0] = start;
                    answer[1] = end;
                }
            }
            sum -= input[start++];
        }
        return answer;
    }
}