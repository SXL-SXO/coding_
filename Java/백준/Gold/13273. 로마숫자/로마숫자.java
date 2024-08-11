import java.util.*;
import java.io.*;

public class Main
{
    static int T, num, len, before, now, atnum;
    static char inputRo[];
    static String input;
    static StringBuilder ro = new StringBuilder("");
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Integer> roTonum = new HashMap<>();
    static Map<Integer, Character> numToro = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		before();

		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
		    input = br.readLine();
		    
		    if('0'<=input.charAt(0)&&input.charAt(0)<='9') isNum();
		    else isRo();
		}
		System.out.print(sb);
	}
	static void isNum(){
	    num = Integer.parseInt(input);
	    len = input.length();
	    ro.setLength(0);
	    for(int i=0;i<len;i++){
	        atnum = (int)Math.pow(10, len-1-i);
	        now = num/atnum;
	        
	        if(now<=3){
	            for(int j=0;j<now;j++){
	                ro.append(numToro.get(atnum));
	            }
	        }else if(now<=8){
	            for(int j=0;j<5-now;j++){
	                ro.append(numToro.get(atnum));
	            }
	            ro.append(numToro.get(atnum*5));
	            for(int j=0;j<now-5;j++){
	                ro.append(numToro.get(atnum));
	            }
	        }else{
	            for(int j=0;j<10-now;j++){
	                ro.append(numToro.get(atnum));
	            }
	            ro.append(numToro.get(atnum*10));
	        }
	        num %= atnum;
	    }
	    sb.append(ro).append("\n");
	}
	static void isRo(){
	    inputRo = input.toCharArray();
	    len = inputRo.length;
        now = num = roTonum.get(inputRo[len-1]);
        atnum = String.valueOf(num).length();
        for(int i=len-2; i>=0; i--){
            before = now;
            now = roTonum.get(inputRo[i]);
            if(Math.abs(now)<Math.abs(before)) now = -now;
            else if(Math.abs(now)==Math.abs(before)) now = before;
            
            num += now;
        }
        
        sb.append(num).append("\n");
	}
	static void before(){
			
		roTonum.put('I', 1);
		roTonum.put('V', 5);
		roTonum.put('X', 10);
		roTonum.put('L', 50);
		roTonum.put('C', 100);
		roTonum.put('D', 500);
		roTonum.put('M', 1000);
		
		numToro.put(1, 'I');
		numToro.put(5, 'V');
		numToro.put(10, 'X');
		numToro.put(50, 'L');
		numToro.put(100, 'C');
		numToro.put(500, 'D');
		numToro.put(1000, 'M');
	    
	}
}
