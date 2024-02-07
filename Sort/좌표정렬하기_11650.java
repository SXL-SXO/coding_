import java.io.*;
import java.util.*;

public class 좌표정렬하기_11650 {
        public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num[][] = new int [N][2];
        for(int i=0; i<N;i++){
            StringTokenizer getNum = new StringTokenizer(br.readLine());
            num[i][0]=Integer.parseInt(getNum.nextToken());
            num[i][1]=Integer.parseInt(getNum.nextToken());
        }
        Arrays.sort(num, (o1, o2) -> { 
            if(o1[0]==o2[0])
                return Integer.compare(o1[1],o2[1]);
            else
                return Integer.compare(o1[0],o2[0]); 
        });
        for(int i=0; i<N;i++){
            System.out.println(num[i][0]+" "+num[i][1]);
        }
    }
}
