import java.io.*;
import java.util.*;

public class 잃어버린괄호_1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        char input[] = br.readLine().toCharArray();
        int answer = 0;
        boolean type = false; // +
        StringBuilder sb = new StringBuilder();
        for(char c : input){
            if(c!='-' && c!='+') {
                sb.append(c);
                continue;
            }
            if(type) answer -= Integer.parseInt(sb.toString());
            else answer += Integer.parseInt(sb.toString());
            sb.setLength(0);
            if(c=='-' && !type) type = !type ; 
        }
        if(type) answer -= Integer.parseInt(sb.toString());
        else answer += Integer.parseInt(sb.toString());
        System.out.println(answer);
    }   
}
