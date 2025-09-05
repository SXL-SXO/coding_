// 07:54
class Solution {
    static int N, answer = 0;
    static int input[], dp[][];
    public int solution(int[] money) {
        N = money.length;
        input = money;
        
        dp = new int[2][N];
        
        if(N==3) return Math.max(Math.max(input[0], input[1]), input[2]);
        
        dp[0][0] = 0;
        dp[1][0] = input[0];
        
        dp[0][1] = input[1];
        dp[1][1] = input[0];
        
        dp[0][2] = Math.max(input[1], input[2]);
        dp[1][2] = input[0]+input[2];
        
        for(int i=3;i<N-1;i++){
            dp[0][i] = Math.max(dp[0][i-3], dp[0][i-2])+input[i];
            dp[0][i] = Math.max(dp[0][i], dp[0][i-1]);
            dp[1][i] = Math.max(dp[1][i-3], dp[1][i-2])+input[i];
            dp[1][i] = Math.max(dp[1][i], dp[1][i-1]);
        }
        
        if(N%2 == 1) {
            dp[0][N-1] = Math.max(dp[0][N-4], dp[0][N-3])+input[N-1];
            dp[0][N-1] = Math.max(dp[0][N-1], dp[0][N-2]);
            dp[1][N-1] = Math.max(dp[1][N-4], dp[1][N-3]);
            dp[1][N-1] = Math.max(dp[1][N-1], dp[1][N-2]);
        }else{
            dp[0][N-1] = Math.max(dp[0][N-4], dp[0][N-3])+input[N-1];
            dp[0][N-1] = Math.max(dp[0][N-1], dp[0][N-2]);
            dp[1][N-1] = Math.max(dp[1][N-4], dp[1][N-3]);
            dp[1][N-1] = Math.max(dp[1][N-1], dp[1][N-2]);
        }
        answer = Math.max(dp[0][N-1], dp[1][N-1]);
        
        return answer;
    }
}