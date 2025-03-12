// 09:36 ~
import java.util.*;
class Solution {
    static int len;
    static int leng[];
    public boolean solution(String[] pb) {
        boolean answer = true;
        
        Arrays.sort(pb);
        
        len = pb.length;
        leng = new int[len];
        for(int i=0;i<len;i++) leng[i] = pb[i].length();
        char a[], b[];
        for(int i=0;i<len-1;i++){
            a = pb[i].toCharArray();
            for(int j=i+1;j<len;j++){
                if(leng[i]>=leng[j]) break;
                
                b = pb[j].toCharArray();
                for(int k=0;k<leng[i];k++){
                    if(a[k]!=b[k]) break;
                    if(k==leng[i]-1) return false;
                }
            }
        }
        
        return true;
    }
}