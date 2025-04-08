// 01:42~
import java.util.*;

class Solution {
    static int input[][], answer[];
    static boolean visit[][];
    static int N, M; //n = 길이, m 2진수 곱 2^m = n
    public int[] solution(int[][] arr) {
        
        N = arr.length;
        M = two();
        input = arr;
        visit = new boolean[N][N];
        answer = new int[2];
        
        if(M==0 || check(0, 0, M)) answer[input[0][0]]++;
        
        return answer;
    }
    static boolean check(int sy, int sx, int p){
        if(p==1){
            int count[] = new int[2];
            for(int i=sy; i<sy+2; i++){
                for(int j=sx; j<sx+2; j++){
                    count[input[i][j]]++;      
                }
            }
            if(count[0]==0 || count[1]==0) return true;
            
            answer[0] += count[0];
            answer[1] += count[1];
            return false;
        }
        
        boolean res[] = new boolean[5];
        int ny[] = {0, 0, (int)Math.pow(2, p-1), (int)Math.pow(2, p-1)};
        int nx[] = {0, (int)Math.pow(2, p-1), 0, (int)Math.pow(2, p-1)};
        
        res[4] = true;
        for(int i=0;i<4;i++) {
            res[i] = check(sy+ny[i], sx+nx[i], p-1);
            res[4] &= (input[sy+ny[i]][sx+nx[i]] == input[sy][sx]);
        }
        
        if(res[0] && res[1] && res[2] && res[3] && res[4]) return true;
        for(int i=0;i<4;i++){
            if(res[i]) answer[input[sy+ny[i]][sx+nx[i]]] += 1;
        }
        return false;
    }
    static int two(){
        int count = 0, res = 1;
        for(;;count++){
            if(res == N) return count;
            res *= 2;
        }
    }
}