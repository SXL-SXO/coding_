import java.util.*;
class Solution {
    public int solution(int num, int k) {
        String kk = String.valueOf(k);
        int answer = 0;
        List<String> number = new ArrayList<>(); 
        while(true){
            //System.out.println(number);
            if (num<10){
                number.add(0,String.valueOf(num));
                //System.out.println(number);
                break;
            }
            number.add(0,String.valueOf(num%10));
            num/=10;
        }
        if(number.contains(kk))
            answer=number.indexOf(kk)+1;
        else
            answer=-1;
            
        return answer;
    }
}