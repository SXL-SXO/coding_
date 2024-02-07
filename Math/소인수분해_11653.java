import java.util.*;
import java.io.*;

public class 소인수분해_11653 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sd = new StringBuilder();
        boolean type = true;
        while(type){
            if(N == 1){
                System.out.print("");
                break;
            }
            else if(N == 2){
                System.out.print(N+"\n");
                break;
            }
            for(int i=2;i<N;i++){
                if(N%i==0){
                    sd.append(i+"\n");
                    N/=i;
                    break;
                }
                if(i==N-1){
                    sd.append(N+"\n");
                    type = false;
                }
            }
        }
        System.out.print(sd.toString());
    }
}
