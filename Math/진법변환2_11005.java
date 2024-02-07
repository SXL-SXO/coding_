import java.util.*;
import java.io.*;

public class 진법변환2_11005 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer getNum = new StringTokenizer(br.readLine());

        int Nnumber = Integer.parseInt(getNum.nextToken());
        long N = Integer.parseInt(getNum.nextToken());
        long NN = N;
        StringBuilder answer = new StringBuilder();
        while(NN<Nnumber+1){
            NN*=N;
        }
        NN/=N;
        while(NN!=0){
            if (Nnumber/NN>9)
                answer.append((char)(Nnumber/NN-10+'A')+"");
            else
                answer.append(Nnumber/NN+"");
             
            //System.out.print(answer + " ");
            Nnumber%=NN;
            NN/=N;
        }
        br.close();
        System.out.print(answer.toString());
    }
}