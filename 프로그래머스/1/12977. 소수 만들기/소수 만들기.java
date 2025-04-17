// 12:43
class Solution {
    static int answer = 0, N;
    static int input[];
    static boolean num[] = new boolean[3001];
    public int solution(int[] nums) {
        N = nums.length;
        input = nums;
        
        sosu();
        for(int i=0;i<N-2;i++) make(i, input[i], 1);

        return answer;
    }
    static void make(int idx, int sum, int count){
        if(count == 3){
            if(!num[sum]) answer++;        
            return;
        }
        for(int i=idx+1; i<N-(2-count); i++) make(i, sum+input[i], count+1);
    }
    static void sosu(){
        for(int i=3; i<=3000; i+=2) {
            for(int j=3; i*j<=3000; j+=2){
                num[i*j] = true;
            }
        }
        for(int i=4;i<=3000;i+=2) num[i] = true;
    }
}