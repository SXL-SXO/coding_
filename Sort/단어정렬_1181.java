import java.io.*;
import java.util.*;

public class 단어정렬_1181 {
        public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String word[] = new String [N];
        StringBuilder a = new StringBuilder();
        String blank = "                                                 ";

        for(int i=0; i<N;i++){
            a=new StringBuilder(blank);
            a.append(br.readLine());
            if(a.length()>50)
                a=new StringBuilder(a.toString().substring(a.length()-50));
            word[i]=a.toString();
        }
        Arrays.sort(word);
        System.out.println(word[0].replace(" ",""));
        int j=1;
        for(int i=1; i<N;i++){
            if(!word[i].equals(word[i-j]))  {
                System.out.println(word[i].replace(" ",""));
                j=1;
            }
            else j+=1;
        }
    }
}