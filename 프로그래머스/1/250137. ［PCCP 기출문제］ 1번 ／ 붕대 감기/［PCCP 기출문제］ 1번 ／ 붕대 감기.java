class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        for(int i=0;i<attacks.length-1;i++){            
            answer -= attacks[i][1];
            if(answer<=0) return -1;
            
            answer += (attacks[i+1][0]-attacks[i][0]-1)*bandage[1];
            answer += (attacks[i+1][0]-attacks[i][0]-1)/bandage[0]*bandage[2];
            if(answer>health) answer = health;
        }
        answer -= attacks[attacks.length-1][1];
        if(answer<=0) return -1;
        return answer;
    }
}