// 11:51
import java.util.*;
class Solution {
    static int N, M, count = 0;
    static String w[];
    static int n[];
    static Map<String, Integer> sliding = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        N = want.length;
        M = discount.length;
        w = want;
        n = number;
        
        for(int i=0;i<10;i++) sliding.put(discount[i], sliding.getOrDefault(discount[i], 0)+1);
        if(check()) answer++;
        
        int start = 0, end = 10;
        for(;end<M;end++){
            sliding.put(discount[end], sliding.getOrDefault(discount[end], 0)+1);
            sliding.put(discount[start], sliding.get(discount[start++])-1);
            if(check()) answer++;
        }
        
        
//         //start 내 시작범위
//         //end 내가 다음으로 포함 예정인 녀석
//         int start = 0, end = 0, temp1, temp2;
//         for(;end<M;end++){
//             temp1 = product.getOrDefault(discount[end], 0);
//             temp2 = sliding.getOrDefault(discount[end], 0);
            
//             if(temp1 == 0) start++; // 아예 포함 안되는 녀석
//             else if(temp2==temp1){
//                 // 앞쪽에 이미 가득 차있는 녀석을 지우고 뒤에 녀석을 넣어야 할 때
//                 while(start<end && discount[start]!=discount[end]){
//                     sliding.put(discount[start], sliding.get(discount[start])-1);
//                     start++;
//                 }
//             }else{
//                 // 포함되는데 아직 남은 쪽
//                 sliding.put(discount[end], temp2+1);
//             }
            
//             if(end-start+1==count) {
//                 System.out.println(start+" "+end);
//                 answer++;
//             }
//         }
        
        return answer;
    }
    static boolean check(){
        for(int i=0;i<N;i++) if(sliding.getOrDefault(w[i], 0)<n[i]) return false;
        return true;
    }
}