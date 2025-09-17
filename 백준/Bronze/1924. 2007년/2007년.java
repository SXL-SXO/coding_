import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    int diff = 0;
	    
	    if(N>=2) diff += 31;
	    if(N>=3) diff += 28;
	    if(N>=4) diff += 31;
	    if(N>=5) diff += 30;
	    if(N>=6) diff += 31;
	    if(N>=7) diff += 30;
	    if(N>=8) diff += 31;
	    if(N>=9) diff += 31;
	    if(N>=10) diff += 30;
	    if(N>=11) diff += 31;
	    if(N>=12) diff += 30;
	    
	    diff += M-1;
	    diff %= 7;
	    
	    if(diff == 0) sb.append("MON");
	    else if(diff == 1) sb.append("TUE");	 
	    else if(diff == 2) sb.append("WED");	 
	    else if(diff == 3) sb.append("THU");
	    else if(diff == 4) sb.append("FRI");	 
	    else if(diff == 5) sb.append("SAT");	 
	    else sb.append("SUN");	
	    
	    System.out.print(sb);
	}
}
