// 10:55
import java.util.*;
class Solution {
    static int N, M;
    static long input[], answer[];
    static StringBuilder sb;
    public long[] solution(long[] numbers) {
        N = numbers.length;
        
        input = numbers;
        answer = new long[N];
        
        
        total : for(int i=0;i<N;i++){
            sb = new StringBuilder(Long.toBinaryString(input[i]));
            M = sb.length();
            oneToZero(i, zeroToOne(i));
        }
        
        return answer;
    }
    static int zeroToOne(int idx){
        for(int j=M-1;j>=0;j--){
            if(sb.charAt(j)=='0') {
                answer[idx] = input[idx] + (long)Math.pow(2, M-1-j);
                return j;
            }
        }
        answer[idx] = input[idx] + (long)Math.pow(2, M) - (long)Math.pow(2, M-1);
        return M;
    }
    static void oneToZero(int idx, int next){
        for(int j=next+1;j<M;j++){
            if(sb.charAt(j)=='1') {
                answer[idx] -= (long)Math.pow(2, M-1-j);
                return;
            }
        }
    }
}