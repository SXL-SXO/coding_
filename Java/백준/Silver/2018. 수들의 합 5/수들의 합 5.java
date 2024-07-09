import java.io.*;
public class Main
{
    static int N, answer=1, count=1, min=1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=2;i<=(N+1)/2;i++){
		    count += i;
		    while(count>N){
		        count-=min;
		        min++;
		    }
		    if(count==N){
		        answer++;
		    }
		}
		System.out.print(answer);
	}
}
