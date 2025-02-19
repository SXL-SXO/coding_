import java.util.*;
import java.io.*;
public class Main
{
    static int L, N, T, answer = 0;
    static int where[], box[];
    static boolean way[];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    L = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    T = Integer.parseInt(st.nextToken());
	    
	    where = new int[N];
	    way = new boolean[L];
	    box = new int[L+1];
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        
	        where[i] = Integer.parseInt(st.nextToken());
	        way[i] = st.nextToken().charAt(0) == 'R';
	        
	        if((where[i]==0&&!way[i])||(where[i]==L)&&way[i]) way[i] = !way[i];
	    }
	    
	    for(int t=0;t<T;t++){
	        Arrays.fill(box, -1);
	        for(int i=0;i<N;i++){
    	        if(way[i]) where[i]++;
    	        else where[i]--;
    	        
    	        
    	        if(box[where[i]]<0) box[where[i]] = i;
    	        else{
    	            way[i] = !way[i];
    	            way[box[where[i]]] = !way[box[where[i]]];
    	            answer++;
    	        }
    	        
    	        if(where[i]==0||where[i]==L) way[i] = !way[i];
	        }
	    }
		System.out.println(answer);
	}
}
