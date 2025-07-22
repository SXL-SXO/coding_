// 09:46~
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int now = num;
        while(now<=n){
            answer++;         
            now += (w-((now-1)%w))*2-1;   
            
            // System.out.print(now+" ");
        }
        
        // if((now-1)/w == (n-1)/w) answer--;
        return answer;
    }
}