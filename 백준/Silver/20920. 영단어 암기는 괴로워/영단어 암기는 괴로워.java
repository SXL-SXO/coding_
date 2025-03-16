import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static Map<String, Integer> map = new HashMap<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->
        o1.count==o2.count?o1.len==o2.len? o1.word.compareTo(o2.word) : o2.len-o1.len : o2.count-o1.count);
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    String word;
	    for(int i=0;i<N;i++){
	        word = br.readLine();
	        map.put(word, map.getOrDefault(word, 0)+1);
	    }
	    
	    for(String w : map.keySet()){
	        pq.offer(new Node(w, map.get(w)));
	    }
	    
	    Node temp;
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	        if(temp.len>=M) sb.append(temp.word).append("\n");
	    }
		System.out.println(sb);
	}
	static class Node{
	    int count, len;
	    String word;
	    Node(String word, int count){
	        this.word=word;
	        this.count=count;
	        len = word.length();
	    }
	}
}
