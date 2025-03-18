// 09:28~52 10:45~

import java.util.*;
class Solution {
    static Map<String, Integer> a = new HashMap<>();
    static Map<String, Integer> b = new HashMap<>();
    static StringBuilder sb;
    public int solution(String str1, String str2) {
        
        insert(str1.toLowerCase(), str1.length(), a);
        insert(str2.toLowerCase(), str2.length(), b);
        
        if(a.size()==0 && b.size()==0) return 65536;
        
        double res = sub()*1.0/sum();
        System.out.print(res);
        
        return (int)(res*65536);
    }
    static int sum(){
        int total = 0;
        
        int count;
        for(String s: a.keySet()){
            count = b.getOrDefault(s, 0);
            total += Math.max(count, a.get(s));
        }
        for(String s: b.keySet()){
            count = a.getOrDefault(s, 0);
            if(count==0) total += b.get(s);
        }
        
        return total;
    }
    static int sub(){
        int total = 0;
        
        int count;
        for(String s: a.keySet()){
            count = b.getOrDefault(s, 0);
            total += Math.min(count, a.get(s));
        }
        
        return total;
    }
    
    static void insert(String str, int len, Map<String, Integer> map){
        sb = new StringBuilder(str);
        char x, y;
        String sub;
        for(int i=0;i<len-1;i++){
            y = str.charAt(i+1);
            x = str.charAt(i);
            
            if(y-'z'>0 || y-'a'<0) {
                i++;
                continue;
            }if(x-'z'>0 || x-'a'<0) continue;
            
            sub = sb.substring(i, i+2).toString();
            map.put(sub, map.getOrDefault(sub, 0)+1);
        }
    }
}