import java.io.*;
import java.util.*;
public class Main
{
    static int N;
    static String s;
    static String input[];
    static Map<String, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    init();
	    
	    int sum;
	    
	    s = br.readLine();
	    while(!s.equals("BYE")){
	        sum = 0;
	        sb.append(s);
	        input = s.split("\\+");
	        
	        N = input[0].length();
	        for(int i=0;i<N;i+=3){
	            sum += Integer.parseInt(map.get(input[0].substring(i, i+3)))*Math.pow(10, N/3-i/3-1);
	        }
	        
	        N = input[1].length()-1;
	        for(int i=0;i<N;i+=3){
	            sum += Integer.parseInt(map.get(input[1].substring(i, i+3)))*Math.pow(10, N/3-i/3-1);
	        }
	        
	        input = String.valueOf(sum).split("");
	        N = input.length;
	        for(int i=0;i<N;i++) sb.append(map.get(input[i]));
	        sb.append("\n");
	        
	        s = br.readLine();
	    }
	    
		System.out.println(sb);
	}
	static void init(){
	    map.put("0", "063");
	    map.put("1", "010");
	    map.put("2", "093");
	    map.put("3", "079");
	    map.put("4", "106");
	    map.put("5", "103");
	    map.put("6", "119");
	    map.put("7", "011");
	    map.put("8", "127");
	    map.put("9", "107");
	    
	    map.put("063", "0");
	    map.put("010", "1");
	    map.put("093", "2");
	    map.put("079", "3");
	    map.put("106", "4");
	    map.put("103", "5");
	    map.put("119", "6");
	    map.put("011", "7");
	    map.put("127", "8");
	    map.put("107", "9");
	    
	}
}
