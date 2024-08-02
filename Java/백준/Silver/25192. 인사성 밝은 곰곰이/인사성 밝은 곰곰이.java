import java.util.*;
import java.io.*;

public class Main
{
    static Map<String, Integer> map;
    static int N, answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        String input;
        for(int i=0;i<N;i++){
            input = br.readLine();
            if(input.equals("ENTER")) {
                map = new HashMap<>();
                continue;
            }
            if(!map.containsKey(input)){
                answer ++;
                map.put(input, 0);
            }
        }
        
        System.out.print(answer);
    }
}