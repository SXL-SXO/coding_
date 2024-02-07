import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 약수들의합_9506 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
        int N,num;
        StringBuilder answer = new StringBuilder();
        while(true){
            N = Integer.parseInt(br.readLine());
            answer.delete(0,answer.length());
            answer.append(N+" = 1");
            num=1;
            if(N==-1)
                break;
            for(int i=2;i<N;i++){
                if(N%i==0){ 
                    num+=i;
                    answer.append(" + "+i);
                }
                if(num>N) {
                    break;
                }
            }

            if(N!=num){
                answer.delete(0,answer.length());
                answer.append(N+" is NOT perfect.");
            }
            System.out.println(answer.toString());

        }
        
    }
}
