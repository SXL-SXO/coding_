import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static String num[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};    
    static Map<String, Integer> map = new HashMap<>();
    static PriorityQueue<String> pq = new PriorityQueue<>();
    static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    M = sc.nextInt();
	    
	    map.put("zero", 0);
	    map.put("one", 1);
	    map.put("two", 2);
	    map.put("three", 3);
	    map.put("four", 4);
	    map.put("five", 5);
	    map.put("six", 6);
	    map.put("seven", 7);
	    map.put("eight", 8);
	    map.put("nine", 9);
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i=N;i<=M;i++){
	        sb.setLength(0);
	        
	        if(i/10 > 0) sb.append(num[i/10]).append(" ");
	        sb.append(num[i%10]);
	        
	        pq.offer(sb.toString());
	    }
	    
	    String temp[];
	    int i=1;
	    while(!pq.isEmpty()){
	        temp = pq.poll().split(" ");
	        
	        if(temp.length==2){
	            answer.append(map.get(temp[0])).append(map.get(temp[1])).append(" ");
	        }else{
	            answer.append(map.get(temp[0])).append(" ");
	        }
	        
	        if(i++%10==0) answer.append("\n");
	    }
		System.out.println(answer);
	}
}
