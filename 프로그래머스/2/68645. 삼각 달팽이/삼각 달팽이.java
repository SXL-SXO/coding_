// 02:35
class Solution {
    static int N;
    static int answer[];
    public int[] solution(int n) {
        N = n*(n+1)/2;
        answer = new int[N];
        
        int M = 0, where = 0, weight = 1, type = 0;
        for(int i=1;i<=N;i++){
            answer[where] = i;
            if(type == 0){
                where += M+weight++;
                if(weight == n-M*2) {
                    type = 1;
                    weight = 1;
                }
            }else if(type == 2){
                where++;
                weight++;
                if(weight == n-M*3){
                    type = 2;
                    weight = n-M-1;
                }
            }else{
                where -= weight--;
                if(weight == M*2){
                    M++;
                    type = 0;
                    weight = 1;
                }
            }
        }
        
        
        // for(int i=1;i<=N;i++){
        //     answer[where] = i;
        //     if(type == 0) {
        //         where += weight++;
        //         if(weight == n-M*2) {
        //             type = 1;
        //             weight = 1;
        //         }
        //     }else if(type == 1){
        //         where++;
        //         weight++;
        //         if(weight == n-(M+1)*3) type = 2;
        //     }else{
        //         where -= n-M+weight--;
        //         if(weight == (M+1)*2-1) {
        //             type = 0;
        //             M++;
        //         }
        //     }
        // }
        
        return answer;
    }
}