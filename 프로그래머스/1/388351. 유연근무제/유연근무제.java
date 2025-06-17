// 03:20
class Solution {
    static int N, answer = 0;
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        N = schedules.length;
        
        int limit, count;
        for(int i=0;i<N;i++){
            limit = schedules[i]/100*100 + (schedules[i]%100+10)/60*100 + (schedules[i]%100+10)%60;
            
            count = 0;
            for(int j=0;j<7;j++){
                if((startday - 1 + j)%7 == 5 || (startday - 1 + j)%7 == 6) continue;
                else if(timelogs[i][j]<=limit) count++;
            }
            if(count==5) answer++;
        }
        
        return answer;
    }
}