// 07:19
import java.util.*;

class Solution {
    static int len, p, os, oe;
    static StringBuilder sb = new StringBuilder();
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        String temp[];
        
        temp = video_len.split(":");        
        len = Integer.parseInt(temp[0])*60;
        len += Integer.parseInt(temp[1]);
        
        temp = pos.split(":");        
        p = Integer.parseInt(temp[0])*60;
        p += Integer.parseInt(temp[1]);
        
        temp = op_start.split(":");        
        os = Integer.parseInt(temp[0])*60;
        os += Integer.parseInt(temp[1]);
        
        temp = op_end.split(":");        
        oe = Integer.parseInt(temp[0])*60;
        oe += Integer.parseInt(temp[1]);
        
        int now = p;
        for(String c: commands){
            if(os<=now && now<oe) now = oe;
            
            if(c.equals("next")) now += 10;
            else now -= 10;
            
            if(now<0) now = 0;
            else if(now>len) now = len;
        }
        if(os<=now && now<oe) now = oe;
        
        if(now/60 < 10) sb.append("0");
        sb.append(now/60).append(":");
        if(now%60 < 10) sb.append("0");
        sb.append(now%60);
        
        return sb.toString();
    }
}