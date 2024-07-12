import java.io.*;
import java.util.*;
public class Main
{
    static int N, M;
    static int input[];
    static int pal[][];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        input = new int[N];
        pal = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0;i<N;i++){
            isPal(i);   
        }
        
        M = Integer.parseInt(br.readLine());
        int start, end, total, answer;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken())-1;
            end = Integer.parseInt(st.nextToken())-1;
            
            total = (start+end)/2;
            answer = pal[total][(start+end)%2] >= end-start ? 1 : 0;
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
	}
	static void isPal(int idx){for(int i=1;;i++){
	        if(idx-i<0 || idx+i>=N || input[idx-i]!=input[idx+i]) {
	            pal[idx][0] = (i-1)*2+1;
	            break;
	        }
	    }
	    for(int i=0;;i++){
	        if(idx-i<0 || idx+1+i>=N || input[idx-i]!=input[idx+1+i]){
	            pal[idx][1] = i*2;
	            break;
	        }
	    }
	}
}
