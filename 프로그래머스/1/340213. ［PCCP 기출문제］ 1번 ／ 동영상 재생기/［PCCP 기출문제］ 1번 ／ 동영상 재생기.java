class Solution {
    static int N, t, os, oe;
    static StringBuilder sb = new StringBuilder();
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String temp[];
        
        temp = video_len.split(":");
        N = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        
        temp = pos.split(":");
        t = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        
        temp = op_start.split(":");
        os = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        
        temp = op_end.split(":");
        oe = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);        
        
        if(os <= t && t< oe) t = oe;
        for(String c:commands){
            if(c.equals("prev")) t -= 10;
            else t += 10;
            
            if(t<0) t = 0;
            else if(t>N) t = N;
            
            if(os <= t && t < oe) t = oe;
        }
        
        if(t/60 < 10) sb.append(0);
        sb.append(t/60).append(":");
        if(t%60 < 10) sb.append(0);
        sb.append(t%60);
        return sb.toString();
    }
}