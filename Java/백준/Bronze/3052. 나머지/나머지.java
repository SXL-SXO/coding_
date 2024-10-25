import java.util.*;
import java.io.*;

public class Main
{
    static Map<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<10;i++){
		    map.put(Integer.parseInt(br.readLine())%42, 0);
		}
		System.out.print(map.size());
	}
    
}
