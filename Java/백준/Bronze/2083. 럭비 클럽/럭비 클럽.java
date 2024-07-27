import java.util.*;
import java.io.*;
public class Main
{
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String name;
	    while(true){
	        st = new StringTokenizer(br.readLine());
	        name = st.nextToken();
	        if(name.equals("#")) break;
	        
	        sb.append(name);
	        if(Integer.parseInt(st.nextToken())>17 ||Integer.parseInt(st.nextToken())>=80) sb.append(" Senior\n");
	        else sb.append(" Junior\n");
	    }
		System.out.println(sb);
	}
}
