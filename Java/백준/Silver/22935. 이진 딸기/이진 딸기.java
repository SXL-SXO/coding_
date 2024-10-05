import java.io.*;
import java.util.*;
public class Main
{
    static int T, N;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String answer[] = {
	        "VVV딸기",
	        "VV딸기V",
	        "VV딸기딸기",
	        "V딸기VV",
	        "V딸기V딸기",
	        "V딸기딸기V",
	        "V딸기딸기딸기",
	        "딸기VVV",
	        "딸기VV딸기",
	        "딸기V딸기V",
	        "딸기V딸기딸기",
	        "딸기딸기VV",
	        "딸기딸기V딸기",
	        "딸기딸기딸기V",
	        "딸기딸기딸기딸기"
	    };
	    
	    T = Integer.parseInt(br.readLine());
	    for(int t=0;t<T;t++){
	       // 1 ~ 15 14 13 12 11 10 9 8 7 6 5 4 3 2
	       //
	        N = Integer.parseInt(br.readLine())-1;
	        N %= 28;
	        if(N<=14) sb.append(answer[N]).append("\n");
	        else sb.append(answer[14-(N-14)]).append("\n");
	    }
		System.out.println(sb);
	}
}
