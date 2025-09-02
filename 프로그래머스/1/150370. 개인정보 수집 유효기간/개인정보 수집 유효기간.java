// 02:47
import java.util.*;
class Solution {
    static int N, count = 0;
    static boolean vaild[];
    static int month[] = new int[26];
    static int today[], answer[];
    public int[] solution(String td, String[] terms, String[] privacies) {
        N = privacies.length;
        vaild = new boolean[N];
                
        today = change(td);        
        
        int idx = 0;
        String temp[];
        for(String t: terms){
            temp = t.split(" ");
            month[temp[0].charAt(0)-'A'] = Integer.parseInt(temp[1]);
        }
        for(String p: privacies){
            temp = p.split(" ");
            if(!isEx(change(temp[0]), month[temp[1].charAt(0)-'A'])) {
                vaild[idx] = true;
                count++;
            }
            idx++;
        }
        
        idx = 0;
        answer = new int[count];
        for(int i=0;i<N;i++) if(vaild[i]) answer[idx++] = i+1;
        
        return answer;
    }
    static int[] change(String s){
        String temp[] = s.split("\\.");
        int res[] = new int[3];
        for(int i=0;i<3;i++) res[i] = Integer.parseInt(temp[i]);         
        return res;
    }
    static boolean isEx(int date[], int add){
        date[1] += add;
        if(date[1]>12) {
            date[0] += (date[1]-1)/12;
            date[1] = (date[1]-1)%12+1;
        }
        return today[0]<date[0] || (today[0]==date[0] && today[1]<date[1]) || (today[0]==date[0] && today[1]==date[1] && today[2]<date[2]);
    }
}