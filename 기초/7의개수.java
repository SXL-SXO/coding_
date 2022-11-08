import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        String aa = "";
        for(int i=0;i<array.length;i++){
             aa+=String.valueOf(array[i]);
        }
        String[] aaa=aa.split("");
        for(String b : aaa){
            if(b.equals("7"))
                answer++;
        }
        return answer;
    }
}