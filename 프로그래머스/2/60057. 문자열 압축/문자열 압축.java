// 06:39~
import java.util.*;
class Solution {
    static int N, answer;
    static StringBuilder sb = new StringBuilder();
    public int solution(String s) {
        answer = N = s.length();
        
        String before, now;
        int count;
        for(int i=N/2;i>0;i--){
            sb.setLength(0);
            
            now = s.substring(0, i);
            count = 1;
            for(int j=i*2;j<N;j+=i){
                before = now;
                now = s.substring(j-i, j);
                
                if(before.equals(now)) count++;
                else {
                    sb.append(before);
                    
                    if(count>1) sb.append(count);
                    count = 1;
                }
            }
            
            before = now;
            if(N % i == 0) now = s.substring(N - i);
            else now = s.substring(N - N%i);
            // System.out.print(before+" "+now+" ");
            
            if(before.equals(now)) sb.append(before).append(count+1);
            else {
                sb.append(before);
                if(count>1) sb.append(count);
                sb.append(now);
            }
            
            // System.out.println(sb);
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}