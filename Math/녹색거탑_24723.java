import java.io.*;
import java.util.*;

public class 녹색거탑_24723 {
     public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int answer=1;
        for(int i=1;i<N+1;i++){
            answer*=2;
        }
        System.out.print(answer);
    }   
}
