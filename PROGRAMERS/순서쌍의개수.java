import java.util.*;
import java.lang.Math;
class Solution {
    public int solution(int n) {
        int answer = 0;
        // int i=1;
        // int limmit =(int)Math.sqrt(n);
//         while(true){
//             if(n/i==i){
//                 answer++;
//                 break;
//             }
//             else if(n/i<i)
//                 break;
//             if(n%i==0){
//                 //System.out.println(limmit);
//                 answer+=2;
//             }
            
//         }
        int i=1;
        while(true){
            if(i*i>n)
                break;
            if(i*i==n){ //i/n==i는 안되고 ㅇㅒ는 됨 ㅋ
                answer++;
                break;
            }
            if(n%i==0){
                answer+=2;
            }
            i++;
                
        }
        return answer;
    }
}