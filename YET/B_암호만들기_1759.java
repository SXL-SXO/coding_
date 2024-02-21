import java.io.*;
import java.util.*;

public class B_암호만들기_1759 {
    static int L, C;
    static char input[];
    static StringBuilder sb = new StringBuilder(), answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input = br.readLine().toCharArray();
        Arrays.sort(input);
        
        for(int i=0;i<L;i++){
            sb.append(input[i]);
            if(input[i]=='a'||input[i]=='e'||input[i]=='i'||input[i]=='o'||input[i]=='u')
                check(i, 1);
            else
                check(i, 0);
            sb.setLength(0);
        }
        System.out.println(answer);
    }
    static void check(int idx, int aeiou){
        if(sb.length()==L){
            if(aeiou>=1 || L-aeiou>=2) answer.append(sb).append("\n");
            return;
        }
        for(int i=idx+1;i<L+sb.length();i++){
            sb.append(input[i]);
            if(input[i]=='a'||input[i]=='e'||input[i]=='i'||input[i]=='o'||input[i]=='u')
                check(i, aeiou+1);
            else
                check(i, aeiou);
            sb.setLength(sb.length()-1);
        }
    }
    
}
