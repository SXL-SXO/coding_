import java.util.*;
import java.io.*;

public class Main
{
    static int N, answer = -10000;
    static char input[];
    static int num[], parent[];
    
    
    public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    
	    input = br.readLine().toCharArray();
	    
	    num = new int[N];
	    parent = new int[N];
	    
	    for(int i=0;i<N;i+=2){
	        parent[i] = i;
	        num[i] = input[i]-'0';
	    }
	    
	    make(0);
	    
	    System.out.print(answer);
	    // 1+2+3+4+5+6+7+8+9+0
    }
    static void make(int visit){
        if(visit == (1<<N/2)-1){
            // System.out.println(Arrays.toString(num));
            answer = Math.max(answer, num[0]);
            return;
        }
        int idx1, idx2, temp1, temp2, res;
        
        for(int j=0;j<N-1;j+=2){
            if((visit & (1<<(j/2))) != 0) continue;
            idx1 = find(j);
            temp1 = num[idx1];
            idx2 = find(j+2);
            temp2 = num[idx2];
	        
	        num[idx1] = 
                input[idx2-1] == '+' ? temp1+temp2 : input[idx2-1] == '-' ? temp1-temp2 : temp1*temp2 ;
            parent[idx2] = idx1;
            
	        make(visit | (1<<(j/2)));
	        
	        num[idx1] = temp1;
	        parent[idx2] = idx2;
	    }
    }
    static int find(int idx){
        if(idx == parent[idx]) return idx;
        
        return find(parent[idx]);
    }
}
