import java.util.*;
import java.io.*;
public class Main
{
    static String answer;
    static int N, NN;
    static char input[];
	static Map<Character, Character> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		before();
		
		answer = br.readLine();
        input = answer.toUpperCase().toCharArray();
        N = input.length;
        NN = (N-1)/2*2;
        
        for(int i=0;i<N;i++){
            if(!map.containsKey(input[i])){
                System.out.print("-1");
                return;
            }
        }
        
        answer = answer+"0"+answer;
        
        for(int i=(N-1)/2;i<N;i++){
            sb.setLength(0);
            check(i, i+1);
            if(map.getOrDefault(input[i], '-') == map.get(map.getOrDefault(input[i], '-'))) {
                sb.setLength(0);
                sb.append(map.get(input[i]));
                check(i-1, i+1);
            }
            
            if(NN-i>=0){
                sb.setLength(0);
                check(NN-i, NN-i+1);
                if(map.getOrDefault(input[NN-i], '-') == map.get(map.getOrDefault(input[NN-i], '-'))) {
                    sb.setLength(0);
                    sb.append(map.get(input[NN-i]));
                    check(NN-i-1, NN-i+1);
                }
            }
            
            if(answer.length()<N*2) break;
        }
        if(answer.length()>2*N) answer = "-1";
		System.out.println(answer);
	}
	static void check(int f, int b) {
	    while(f>=0 || b<N){
	        if(f>=0 && b<N){
	           // System.out.println(map.getOrDefault(input[f], '-')+" "+map.get(map.getOrDefault(input[b], '*')));
	           // System.out.println(map.get(map.getOrDefault(input[f], '-'))+" "+map.getOrDefault(input[b], '*'));
	            
	            if(map.containsKey(input[f]) && map.containsKey(input[b]) 
	            && (map.get(map.getOrDefault(input[f], '-')) == map.getOrDefault(input[b], '*')
	            || map.getOrDefault(input[f], '-') == map.get(map.getOrDefault(input[b], '*')))) {
	                sb.insert(0, map.get(input[b]));
	                sb.append(map.get(input[f]));
	            }
	            else return;
	            f--;
	            b++;
	        }else if(b>=N){
	            if(!map.containsKey(input[f])) return;
	            else {
	                sb.insert(0, map.get(map.get(input[f])));
	                sb.append(map.get(input[f]));
	            }
	            f--;
	        }else if(f<0){
	            if(!map.containsKey(input[b])) return;
	            else {
	                sb.append(map.get(map.get(input[b])));
	                sb.insert(0, map.get(input[b]));
	            }
	            b++;
	        }
	       // System.out.println(sb);
	    }
	    if(sb.length()<answer.length()) answer = sb.toString(); 
	}
	static void before() {
		map.put('A', 'A');
		map.put('B', 'd');
		map.put('b', 'd');
		map.put('D', 'b');
		map.put('d', 'b');
		map.put('E', '3');
		map.put('H', 'H');
		map.put('I', 'I');
		map.put('L', 'l');
		map.put('l', 'l');
		map.put('M', 'M');
		map.put('N', 'n');
		map.put('n', 'n');
		map.put('O', 'O');
		map.put('P', 'q');
		map.put('p', 'q');
		map.put('Q', 'p');
		map.put('q', 'p');
		map.put('R', '7');
		map.put('r', '7');
		map.put('S', '2');
		map.put('T', 'T');
		map.put('U', 'U');
		map.put('V', 'V');
		map.put('W', 'W');
		map.put('X', 'X');
		map.put('Y', 'Y');
		map.put('Z', '5');

		map.put('0', '0');
		map.put('1', '1');
		map.put('2', 'S');
		map.put('3', 'E');
		map.put('5', 'Z');
		map.put('7', 'r');
		map.put('8', '8');
		map.put('-', ' ');
	}
}
