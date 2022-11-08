import java.util.*;
class Solution {
    public String solution(String my_string) {
        char[] aa = new char[my_string.length()];
        for(int i=0;i<my_string.length();i++){
            if (my_string.charAt(i)<97)
                aa[i]=(char)(my_string.charAt(i)+32);
            else
                aa[i]=my_string.charAt(i);
        }
        Arrays.sort(aa);
        String answer= new String(aa);
        return answer;
    }
}