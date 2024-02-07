import java.io.*;
import java.util.*;

public class 좌표압축_18870 {
        public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer getNum = new StringTokenizer(br.readLine());
        
        int []num = new int[N];
        int []num_s = new int[N];
        
        Map<Integer,Integer> rank = new HashMap<Integer,Integer>();
        for(int i=0;i<N;i++){
            num[i] = num_s[i] = Integer.parseInt(getNum.nextToken());
        }
        Arrays.sort(num_s);

        int value = 0;
        for(int j : num_s){
            if(!rank.containsKey(j)){
                rank.put(j,value);
                value+=1;
            }
        }
        
        StringBuilder answer = new StringBuilder ();
        for(int k : num){
            answer.append(rank.get(k)+" ");
        }
        System.out.print(answer);
    }
}