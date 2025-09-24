// 07:01
import java.util.*;
class Solution {
    static int N, K, answer = 0;
    public int solution(int n, int k) {
        N = n;
        K = k;
        
        String input[] = Integer.toString(n, k).split("0");
            // System.out.println(Arrays.toString(Integer.toString(1000000, 9).split("0")));
    
        long temp;
        for(String s : input){
            // System.out.println(s);
            if(s.equals("")) continue;
            
            temp = Long.parseLong(s);
            if(check(temp)) answer++;
        }
        return answer;
    }
    static boolean check(long num){
        if(num == 2) return true;
        else if(num == 1 || num%2 == 0) return false;
        
        for(long i = 3; i<=Math.sqrt(num); i+=2) if(num%i == 0) return false;
        
        return true;
    }
}