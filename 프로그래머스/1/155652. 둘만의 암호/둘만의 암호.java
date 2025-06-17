// 03:28
import java.util.*;
class Solution {
    static int N, M;
    static boolean alpa[];
    static int num[];
    static Map<Integer, Character> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public String solution(String s, String skip, int index) {
        N = s.length();
        M = 26 - skip.length();
        
        alpa = new boolean [26];
        num = new int[M];
        
        for(int a=0;a<26-M;a++){
            alpa[skip.charAt(a)-'a'] = true;
        }
        
        int b = 0;
        for(int a=0;a<26;a++){
            if(alpa[a]) continue;
            num[b++] = a;
        }
        
        b = 0;
        for(int a=0;a<26;a++){
            if(!alpa[a]) map.put(a, (char)(num[(index+b++)%M]+'a'));
        }
        for(int a=0;a<N;a++){
            sb.append(map.get(s.charAt(a)-'a'));
        }
        
        return sb.toString();
    }
}