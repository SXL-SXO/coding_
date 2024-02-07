import java.util.*;
import java.io.*;

public class 최댓값_2566 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];

        int answer[] = {-1,0,0};
        for(int i=0;i<9;i++){
			StringTokenizer str1 = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++){
				arr[i][j] = Integer.parseInt(str1.nextToken());
                if(answer[0]<arr[i][j]){
                    answer[0]=arr[i][j];
                    answer[1] = i+1;
                    answer[2] = j+1;
                }
			}
		}
        System.out.print(answer[0]+"\n"+answer[1]+" "+answer[2]);

    }
  
}  /* 
arr = {{3, 23, 85, 34, 17, 74, 25, 52, 65},
{10, 7, 39, 42, 88, 52, 14, 72, 63},
{87 ,42 ,18 ,78 ,53 ,45 ,18 ,84 ,53},
{34 ,28 ,64 ,85 ,12 ,16 ,75 ,36 ,55},
{21, 77, 45, 35 ,28 ,75 ,90 ,76 ,1},
{25, 87, 65, 15, 28, 11, 37, 28, 74},
{65, 27, 75, 41, 7 ,89 ,78 ,64 ,39},
{47 ,47 ,70, 45 ,23 ,65, 3 ,41 ,44},
{87 ,13 ,82, 38, 31, 12, 29, 29, 80}
};*/
