import java.util.*;
import java.io.*;

public class Main
{
	static int N = 5, answer = 0;
	static int move[] = {-5, -1, 5, 1};
	static char input[][] = new char[5][];
	static Map<Integer, Integer> map = new HashMap<>();
	static Queue<Node> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<N;i++) input[i] = br.readLine().toCharArray();
		
		for(int i=0;i<N*N;i++){
		    bfs(i);
		}
		
		System.out.print(answer);
	}
    static void bfs(int idx){
        queue.clear();
        
        map.put(1<<idx, 0);
	    if(input[idx/N][idx%N] == 'S') queue.offer(new Node(1<<idx, 1, 0));
	    else queue.offer(new Node(1<<idx, 0, 1));
		    
        Node temp;
        while (!queue.isEmpty()){
            temp = queue.poll();
            
            if(temp.Y>3) continue;
            else if(temp.S+temp.Y>= 7) {
                answer++;
                continue;
            }
        
        
            int next;
            for(int i=0;i<25;i++){
                if((temp.visit & (1<<i)) == 0) continue;
                
                for(int j=0;j<4;j++){
                    next = i + move[j];
                    
                    if((temp.visit & (1<<next)) != 0) continue;
                    else if(map.containsKey(temp.visit | (1<<next))) continue;
                    else if(j==0 && i/5 == 0) continue;
                    else if(j==1 && i%5 == 0) continue;
                    else if(j==2 && i/5 == 4) continue;
                    else if(j==3 && i%5 == 4) continue;
                    
                    if(input[next/N][next%N] == 'S') queue.offer(new Node(temp.visit | (1<<next), temp.S+1, temp.Y));
                    else queue.offer(new Node(temp.visit | (1<<next), temp.S, temp.Y+1));
                    
                    map.put(temp.visit | (1<<next), 0);
                }
                
            }
        }
    }
    static class Node{
        int visit, S, Y;
        Node(int visit, int S, int Y){
            this.visit = visit;
            this.S = S;
            this.Y = Y;
        }
    }
}
