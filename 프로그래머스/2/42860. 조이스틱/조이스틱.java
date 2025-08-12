// 07:00
import java.util.*;

class Solution {
    static char input[];
    static int answer, N, A;
    public int solution(String name) {
        input = name.toCharArray();
        N = input.length;
        answer = 27*N; 
        
        for(int i=0;i<N;i++) if(input[i]=='A') A |= (1<<i);
        
        if(A == (1<<N)-1) answer = 0;
        else make(0, 0, 0, 0, 0);
        
        return answer;
    }
    static void make(int front, int back, int visit, int idx, int count){
        if((visit|A) == (1<<N)-1) {
            answer = Math.min(answer, count-1);
            return;
        }
        if((visit & (1<<idx)) == 0) count += Math.min((int)(input[idx]-'A'), (int)('Z'-input[idx])+1);
        
        if((front & (1<<idx)) == 0) make(front | (1<<idx), back, visit | (1<<idx), idx == 0 ? N-1 : idx-1, count+1);
    
        if((back & (1<<idx)) == 0) make(front, back | (1<<idx), visit | (1<<idx), idx == N-1 ? 0 : idx+1, count+1);
    }
}