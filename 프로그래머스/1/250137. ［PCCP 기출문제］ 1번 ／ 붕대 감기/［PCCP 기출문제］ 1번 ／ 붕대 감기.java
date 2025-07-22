// 09:01
class Solution {
    static int H, N;
    public int solution(int[] bandage, int health, int[][] attacks) {
        N = attacks.length;
        
        H = health-attacks[0][1];
        if(H<=0) return -1;
        
        for(int i=1;i<N;i++){
            H += (attacks[i][0]-attacks[i-1][0]-1)*bandage[1];
            H += (attacks[i][0]-attacks[i-1][0]-1)/bandage[0]*bandage[2];
            H = Math.min(health, H);
            
            
            // System.out.println(H+" "+(H-attacks[i][1]));
            H -= attacks[i][1];
            if(H<=0) return -1;
        }
        
        
        return H;
    }
}