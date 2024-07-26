import java.math.*;
import java.io.*;
public class Main
{
    static int N, answer;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0;t<3;t++){
		    N = Integer.parseInt(br.readLine());
		    BigInteger a = new BigInteger("0");
		    BigInteger b = new BigInteger("0");
		    for(int n=0;n<N;n++){
		        b = new BigInteger(br.readLine());
		        a = a.add(b);
		    }
		    answer = a.compareTo(new BigInteger("0"));
		    if(answer>0) sb.append("+\n");
		    else if(answer<0) sb.append("-\n");
		    else sb.append("0\n");
		}
		System.out.print(sb);
	}
}
