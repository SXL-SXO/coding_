import java.util.*;
import java.io.*;
public class Main
{
    static int N, ga = 0, se = 0;
    static char map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N==1){
		    System.out.print(0+" "+0);
            return ;
		}
		map = new char[N][];
		int count = 0;
		
		
		for(int i=0;i<N;i++){
		    map[i] = br.readLine().toCharArray();
		    for(int j=0;j<N;j++){
		        if (map[i][j]=='.'){
		            count++;
		        }else{
		            if(count>1) ga++;
		            count = 0;
		        }
		    }
		    if(count>1) ga++; 
		    count=0;
		}
		for(int i=0;i<N;i++){
		    for(int j=0;j<N;j++){
		        if (map[j][i]=='.'){
		            count++;
		        }else{
		            if(count>1) se++;
		            count = 0;
		        }
		    }
		    if(count>1) se++;
		    count=0;
		}
		System.out.print(ga+" "+se);
		
	}
}
