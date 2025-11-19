
import java.util.*;
import java.io.*;
public class Main
{
    static Map<Character, Character> map = new HashMap<>();
    static String s;
    static char input[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = " ";
		
		while(( s = br.readLine()) != null) {
		    input = s.toCharArray();
    		
    		map.put(' ', ' ');
    		
    		map.put('\\', ']');
    		map.put(']', '[');
    		map.put('[', 'P');
    		map.put('P', 'O');
    		map.put('O', 'I');
    		map.put('I', 'U');
    		map.put('U', 'Y');
    		map.put('Y', 'T');
    		map.put('T', 'R');
    		map.put('R', 'E');
    		map.put('E', 'W');
    		map.put('W', 'Q');
    		
    		map.put('\'', ';');
    		map.put(';', 'L');
    		map.put('L', 'K');
    		map.put('K', 'J');
    		map.put('J', 'H');
    		map.put('H', 'G');
    		map.put('G', 'F');
    		map.put('F', 'D');
    		map.put('D', 'S');
    		map.put('S', 'A');
    		
    		map.put('/', '.');
    		map.put('.', ',');
    		map.put(',', 'M');
    		map.put('M', 'N');
    		map.put('N', 'B');
    		map.put('B', 'V');
    		map.put('V', 'C');
    		map.put('C', 'X');
    		map.put('X', 'Z');
    		
    		map.put('=', '-');
    		map.put('-', '0');
    		map.put('0', '9');
    		map.put('9', '8');
    		map.put('8', '7');
    		map.put('7', '6');
    		map.put('6', '5');
    		map.put('5', '4');
    		map.put('4', '3');
    		map.put('3', '2');
    		map.put('2', '1');
    		map.put('1', '`');
    		
    		
    		
    		for(char c : input) sb.append(map.get(c));
		    sb.append("\n");
		}
		System.out.print(sb);
	}
}
