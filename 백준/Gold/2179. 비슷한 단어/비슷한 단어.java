import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static String input[];
    static Map<String, Integer> word = new HashMap<>();
    static Map<String, Node> map = new HashMap<>();
    static StringBuilder sb;
    static PriorityQueue<Node> pq = new PriorityQueue<>(
        (o1, o2)-> o2.len==o1.len ? o1.idx1==o2.idx1 ? o1.idx2-o2.idx2 : o1.idx1-o2.idx1 : o2.len-o1.len);
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    input = new String[N];
	    for(int i=0;i<N;i++){
	        input[i] = br.readLine();
	        word.put(input[i], i);
	    }
	    
	    Node temp; String ss; 
	    for(int i=0;i<N;i++){
	        sb = new StringBuilder(input[i]);
	        for(int j=sb.length();j>0;j--){
	            ss = sb.substring(0, j).toString();
	            temp = map.getOrDefault(ss, new Node(i, j-1));
	            if( temp.idx1 == i ) {
    	            map.put(ss, temp);
	            }else if( temp.idx2 == -1 ) {
	                temp.idx2 = i;
    	            map.put(ss, temp);
    	            break;
	            }
	        }
	    }
	    
	    for(String s : map.keySet()){
	        temp = map.get(s);
	        if(temp.idx2>=0) pq.offer(temp);
	    }
	    temp = pq.poll();
	    sb.setLength(0);
	    sb.append(input[temp.idx1]).append("\n").append(input[temp.idx2]);
		System.out.println(sb);
	}
	static class Node{
	    int idx1, idx2, len;
	    Node(int idx1, int len){
	        this.idx1 = idx1;
	        this.len = len;
	        idx2 = -1;
	    }
	}
}
