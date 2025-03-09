import java.util.*;
import java.io.*;
public class Main
{
    static String[][] num = {
        {"0000", "   1", "2222", "3333", "4  4", "5555", "6666", "7777", "8888", "9999"},
        {"0  0", "   1", "   2", "   3", "4  4", "5", "6", "   7", "8  8", "9  9"},
        {"0  0", "   1", "2222", "3333", "4444", "5555", "6666", "   7", "8888", "9999"},
        {"0  0", "   1", "2", "   3", "   4", "   5", "6  6", "   7", "8  8", "   9"}, 
        {"0000", "   1", "2222", "3333", "   4", "5555", "6666", "   7", "8888", "   9"}
    };
    static String input[];
    static int N;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    input = br.readLine().split("");
	    for(int i=0;i<input.length;i++){
	        N = Integer.parseInt(input[i]);
	        for(int j=0;j<5;j++){
	            sb.append(num[j][N]).append("\n");
	        }
	        sb.append("\n");
	    }
	    
		System.out.println(sb);
	}
}
