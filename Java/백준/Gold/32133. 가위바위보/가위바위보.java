import java.util.*;
import java.io.*;
public class Main
{
    static char RSP[] = {'R','S','P'};
	static int N, M, K, answer;
	static char output[];
	static char input[][];
	static int win[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = M;
		
		win = new int[N];
		input = new char[N][];
		output = new char[M];
		
		for(int i=0;i<N;i++){
		    input[i] = br.readLine().toCharArray();
		    win[i] = -1;
		}
        
        check(0, N);
        
        if(sb.length()==0) sb.append(-1);
		System.out.println(sb);
	}
	
	static void check(int round, int gift){
	    // 진 사람들이 준비한 선물 수 보다 많아서 선물이 남을때
	    // 남은 사람 수가 준비한 선물수와 같아서 선물을 나눠 줄 수 있을때
	    if(gift<=0) return;
	    else if(gift<=K){
	        sb.setLength(0);
	        sb.append(round).append("\n");
	        for(int i=0;i<round;i++){
	            sb.append(output[i]);
	        }
	        answer = round-1;
	        return;
	    }
	    
	    
	    int count = 0;
	    // 현재 라운드에서 내가 RSP[i]을 내면 지거나 비기는 놈들 카운트
	    for(int i=0;i<3;i++){
	        if(round>=answer) return;
	        
	        output[round] = RSP[i];
	        count = 0;
	        for(int j=0;j<N;j++){
	            // 이미 진 녀석이나 이기는 녀석은 넘어감
	            if(win[j]!=-1 || input[j][round]==RSP[i==0 ? 2:i-1]) continue;
	            
	            win[j] = round;
	            count++;
	        }
	        
	        //System.out.println(Arrays.toString(win)+" "+Arrays.toString(output));
	        
	        check(round+1, gift-count);
	        
	        for(int j=0;j<N;j++){
	            if(win[j]==round) win[j] = -1;
	        }
	    }
	}
}
