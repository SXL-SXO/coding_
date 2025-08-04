// 08:43
class Solution {
    static int N, answer;
    public int solution(String s) {
        N = answer = s.length();
        
        int count;
        String before, now;
        StringBuilder sb = new StringBuilder();
        for(int i=N/2;i>0;i--){
            now = s.substring(0, i);
            count = 1;
            for(int j=i*2;j<=N;j+=i){
                before = now;
                now = s.substring(j-i, j);
                // System.out.println(before+" "+now);
                if(before.equals(now)) count++;
                else{
                    if(count == 1) sb.append(before);
                    else sb.append(count).append(before);
                    
                    count = 1;
                }
            }
            if(count == 1) sb.append(now);
            else sb.append(count).append(now);
            
            answer = Math.min(answer, sb.length()+N%i);
            // System.out.println(answer+" "+sb);
            sb.setLength(0);
        }
        
        return answer;
    }
}