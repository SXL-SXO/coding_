//01:31
import java.util.*;
class Solution {
    static int answer = 0, N, M;
    static int input[][];
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        input = data;
        N = input.length;
        M = input[0].length;
        
        Arrays.sort(input, (o1, o2) -> o1[col-1]==o2[col-1] ? o2[0]-o1[0] : o1[col-1]-o2[col-1]);
        
        int sum;
        for(int i=row_begin;i<=row_end;i++){
            sum = 0;
            
            for(int j=0;j<M;j++) sum += input[i-1][j]%i;  
            answer ^= sum;
        }
        
        return answer;
    }
}