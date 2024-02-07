import java.io.*;
import java.util.*;

public class 팰린드롬수_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String num;
        char N[];
        StringBuilder sb = new StringBuilder();
        while(true){
            num = br.readLine();
            if(num.equals("0")) break;
            N = num.toCharArray();
            int size = sb.length();
            for(int i=0;i<(N.length-1)/2;i++){
                if(N[i]==N[N.length-1-i]) continue;
                else {
                    sb.append("no\n");
                    break;
                }
            }
            if(size==sb.length()) sb.append("yes\n");
        }
        System.out.println(sb.toString());
    }
}
