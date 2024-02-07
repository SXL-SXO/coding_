import java.util.*;
import java.io.*;

public class 진법변환_2745 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer getNum = new StringTokenizer(br.readLine());

        String Nnumber = getNum.nextToken();
        int N = Integer.parseInt(getNum.nextToken());
        int NN = N;
        int answer = 0;
        answer=Nnumber.charAt(Nnumber.length()-1)>'9' ? Nnumber.charAt(Nnumber.length()-1)-'A'+10 : Nnumber.charAt(Nnumber.length()-1)-'0';
        for(int i=1;i<Nnumber.length();i++){
            answer = Nnumber.charAt(Nnumber.length()-i-1)>'9' ? answer+(Nnumber.charAt(Nnumber.length()-1-i)-'A'+10) * NN: answer+(Nnumber.charAt(Nnumber.length()-1-i)-'0')*NN;
            NN*=N;
            
            //System.out.println(answer);
        }
        System.out.print(answer);
    }
}
