import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static boolean result = true;
    static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    map.put("Never gonna give you up", 0);
	    map.put("Never gonna let you down", 0);
	    map.put("Never gonna run around and desert you", 0);
	    map.put("Never gonna make you cry", 0);
	    map.put("Never gonna say goodbye", 0);
	    map.put("Never gonna tell a lie and hurt you", 0);
	    map.put("Never gonna stop", 0);

        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            if(!map.containsKey(br.readLine())) result = false;
        }
        
        if(!result) System.out.println("Yes");
        else System.out.println("No");
	}
}
