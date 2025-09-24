//05:16
class Solution {
    static int N, idx = 0;
    static int answer[][];
    public int[][] solution(int n) {
        N = n;
        answer = new int[(int)Math.pow(2, N)-1][2];
        
        make(1, 3, N);
        
        return answer;
    }
    static void make(int s, int e, int m){ 
        if(m==0) return;
        
        if(s == 1 && e == 2) make(s, 3, m-1);
        else if(s == 1 && e == 3) make(s, 2, m-1);
        else if(s == 2 && e == 1) make(s, 3, m-1);
        else if(s == 2 && e == 3) make(s, 1, m-1);
        else if(s == 3 && e == 1) make(s, 2, m-1);
        else if(s == 3 && e == 2) make(s, 1, m-1);
        
        answer[idx][0] = s;
        answer[idx++][1] = e;
        
        if(s == 1 && e == 2) make(3, e, m-1);
        else if(s == 1 && e == 3) make(2, e, m-1);
        else if(s == 2 && e == 1) make(3, e, m-1);
        else if(s == 2 && e == 3) make(1, e, m-1);
        else if(s == 3 && e == 1) make(2, e, m-1);
        else if(s == 3 && e == 2) make(1, e, m-1);
    }
}